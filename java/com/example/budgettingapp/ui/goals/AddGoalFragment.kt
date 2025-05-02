package com.example.budgettingapp.ui.goals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.budgettingapp.databinding.FragmentAddGoalBinding
import com.example.budgettingapp.viewmodel.BudgetViewModel
import com.example.budgettingapp.data.Goal
import java.time.LocalDateTime

class AddGoalFragment : Fragment() {
    private var _binding: FragmentAddGoalBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: BudgetViewModel
    private val args: AddGoalFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddGoalBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity())[BudgetViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args.goal?.let { goal ->
            // Editing existing goal
            binding.apply {
                title.setText(goal.title)
                targetAmount.setText(goal.targetAmount.toString())
                currentAmount.setText(goal.currentAmount.toString())
                deadline.setText(goal.deadline.toString())
                description.setText(goal.description)
            }
        }

        binding.buttonSave.setOnClickListener {
            val goal = Goal(
                title = binding.title.text.toString(),
                targetAmount = binding.targetAmount.text.toString().toDoubleOrNull() ?: 0.0,
                currentAmount = binding.currentAmount.text.toString().toDoubleOrNull() ?: 0.0,
                deadline = LocalDateTime.parse(binding.deadline.text.toString()),
                description = binding.description.text.toString()
            )

            val existingGoal = args.goal
            if (existingGoal == null) {
                viewModel.insertGoal(goal)
            } else {
                goal.id = existingGoal.id
                viewModel.updateGoal(goal)
            }

            findNavController().navigateUp()
        }

        binding.buttonCancel.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
