package com.example.budgettingapp.ui.expenses

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.budgettingapp.databinding.FragmentExpensesBinding
import com.example.budgettingapp.data.Expense
import com.example.budgettingapp.data.DataManager
import com.example.budgettingapp.ui.expenses.ExpensesAdapter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ExpensesFragment : Fragment() {
    private var _binding: FragmentExpensesBinding? = null
    private val binding get() = _binding!!
    private lateinit var dataManager: DataManager
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
        dataManager = DataManager.getInstance(requireContext())

        setupRecyclerView()
        loadExpenses()
        setupClickListeners()
    }

    private fun setupRecyclerView() {
        adapter = ExpensesAdapter { expense ->
            // Handle item click
        }
        binding.expensesRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@ExpensesFragment.adapter
        }
    }

    private fun loadExpenses() {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val expenses = withContext(Dispatchers.IO) {
                    dataManager.getExpenses()
                }
                adapter.submitList(expenses)
            } catch (e: Exception) {
                // Handle error
            }
        }
    }

    private fun setupClickListeners() {
        binding.btnAddExpense.setOnClickListener {
            findNavController().navigate(R.id.action_navigation_expenses_to_addExpenseFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
