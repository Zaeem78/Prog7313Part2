package com.example.budgettingapp.ui.goals

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.budgettingapp.data.Goal
import com.example.budgettingapp.databinding.ItemGoalBinding

class GoalsAdapter : ListAdapter<Goal, GoalsAdapter.GoalViewHolder>(GoalDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GoalViewHolder {
        val binding = ItemGoalBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return GoalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GoalViewHolder, position: Int) {
        val goal = getItem(position)
        holder.bind(goal)
    }

    class GoalViewHolder(
        private val binding: ItemGoalBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(goal: Goal) {
            binding.apply {
                goalTitle.text = goal.title
                goalTargetAmount.text = "Target: $${goal.targetAmount}"
                goalCurrentAmount.text = "Current: $${goal.currentAmount}"
                goalStartDate.text = "Start: ${goal.timestamp}"
                goalEndDate.text = "End: ${goal.deadline}"
            }
        }
    }

    private class GoalDiffCallback : DiffUtil.ItemCallback<Goal>() {
        override fun areItemsTheSame(oldItem: Goal, newItem: Goal): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Goal, newItem: Goal): Boolean {
            return oldItem == newItem
        }
    }
}
