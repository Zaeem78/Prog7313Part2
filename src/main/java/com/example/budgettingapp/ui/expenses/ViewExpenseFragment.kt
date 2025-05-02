package com.example.budgettingapp.ui.expenses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.budgettingapp.databinding.FragmentViewExpenseBinding
import com.example.budgettingapp.data.Expense

private const val ARG_EXPENSE = "expense"

class ViewExpenseFragment : Fragment() {
    private var _binding: FragmentViewExpenseBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentViewExpenseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val expense = arguments?.getParcelable<Expense>(ARG_EXPENSE)
        
        if (expense != null) {
            // Bind the expense data to the views
            binding.apply {
                title.text = expense.title
                amount.text = "${expense.amount}"
                category.text = expense.category
                date.text = expense.date.toString()
                description.text = expense.description
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
