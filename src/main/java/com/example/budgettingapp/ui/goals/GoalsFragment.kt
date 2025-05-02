package com.example.budgettingapp.ui.goals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.budgettingapp.databinding.FragmentGoalsBinding
import com.example.budgettingapp.viewmodel.BudgetViewModel
import androidx.lifecycle.Observer

private const val ARG_GOALS = "goals"

class GoalsFragment : Fragment() {
    private var _binding: FragmentGoalsBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: BudgetViewModel
    private lateinit var adapter: GoalsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGoalsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this)[BudgetViewModel::class.java]
        adapter = GoalsAdapter()

        binding.goalsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@GoalsFragment.adapter
        }

        viewModel.goals.observe(viewLifecycleOwner) { goals ->
            adapter.submitList(goals)
        }

        binding.fabAddGoal.setOnClickListener {
            findNavController().navigate(com.example.budgettingapp.R.id.action_navigation_goals_to_addGoalFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
