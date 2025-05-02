package com.example.budgettingapp.ui.expenses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.budgettingapp.databinding.FragmentExpensesBinding
import com.example.budgettingapp.viewmodel.BudgetViewModel
import androidx.navigation.fragment.navArgs
import kotlinx.coroutines.launch
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import com.example.budgettingapp.R
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Lifecycle

class ExpensesFragment : Fragment() {
    private var _binding: FragmentExpensesBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: BudgetViewModel
    private lateinit var adapter: ExpensesAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExpensesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[BudgetViewModel::class.java]
        adapter = ExpensesAdapter { expense ->
            val action = findNavController().navigate(
                R.id.action_navigation_expenses_to_view_expense_fragment,
                Bundle().apply {
                    putParcelable("expense", expense)
                }
            )
        }
        binding.rvExpenses.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = this@ExpensesFragment.adapter
        }

        viewModel.expenses.observe(viewLifecycleOwner) { expenses ->
            adapter.submitList(expenses)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
