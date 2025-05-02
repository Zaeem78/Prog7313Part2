package com.example.budgettingapp.ui.expenses

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.budgettingapp.data.Expense
import com.example.budgettingapp.databinding.ItemExpenseBinding
import com.squareup.picasso.Picasso
import java.text.SimpleDateFormat
import java.util.*

class ExpensesAdapter(private val onClick: (Expense) -> Unit) :
    ListAdapter<Expense, ExpensesAdapter.ExpenseViewHolder>(ExpenseDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseViewHolder {
        val binding = ItemExpenseBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ExpenseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExpenseViewHolder, position: Int) {
        val expense = getItem(position)
        holder.bind(expense)
    }

    inner class ExpenseViewHolder(private val binding: ItemExpenseBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onClick(getItem(position))
                }
            }
        }

        fun bind(expense: Expense) {
            binding.apply {
                tvTitle.text = expense.title
                tvAmount.text = "${expense.amount}"
                tvCategory.text = expense.category
                tvDate.text = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(Date())
                tvNote.text = expense.note

                expense.imageUrl?.let { url ->
                    Picasso.get()
                        .load(url)
                        .into(ivExpenseImage)
                }
            }
        }
    }

    private class ExpenseDiffCallback : DiffUtil.ItemCallback<Expense>() {
        override fun areItemsTheSame(oldItem: Expense, newItem: Expense): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Expense, newItem: Expense): Boolean {
            return oldItem == newItem
        }
    }
}
