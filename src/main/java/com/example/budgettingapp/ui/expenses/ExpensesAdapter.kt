package com.example.budgettingapp.ui.expenses

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.budgettingapp.data.Expense
import com.example.budgettingapp.databinding.ItemExpenseBinding
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.Locale

class ExpensesAdapter(
    private val onItemClicked: (Expense) -> Unit
) : ListAdapter<Expense, ExpensesAdapter.ExpenseViewHolder>(DiffCallback()) {

    private val dateFormatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
        .withLocale(Locale.getDefault())
    private val timeFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)
        .withLocale(Locale.getDefault())

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        return ExpenseViewHolder(
            ItemExpenseBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    inner class ExpenseViewHolder(private var binding: ItemExpenseBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onItemClicked(getItem(position))
                }
            }
        }

        fun bind(expense: Expense) {
            binding.apply {
                title.text = expense.title
                amount.text = "${expense.amount}"
                category.text = expense.category
                date.text = dateFormatter.format(expense.date)
                startTime.text = timeFormatter.format(expense.startTime)
                endTime.text = timeFormatter.format(expense.endTime)
                description.text = expense.description
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<Expense>() {
        override fun areItemsTheSame(oldItem: Expense, newItem: Expense): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Expense, newItem: Expense): Boolean {
            return oldItem == newItem
        }
    }
}
