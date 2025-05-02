package com.example.budgettingapp.data.repository

import com.example.budgettingapp.data.BudgetDatabase
import com.example.budgettingapp.data.Expense
import com.example.budgettingapp.data.BudgetGoal
import kotlinx.coroutines.flow.Flow

class BudgetRepository(private val database: BudgetDatabase) {
    // Expenses
    val allExpenses: Flow<List<Expense>> = database.expenseDao().getAllExpenses()

    suspend fun insertExpense(expense: Expense) {
        database.expenseDao().insertExpense(expense)
    }

    suspend fun updateExpense(expense: Expense) {
        database.expenseDao().updateExpense(expense)
    }

    suspend fun deleteExpense(expense: Expense) {
        database.expenseDao().deleteExpense(expense)
    }

    // Budget Goals
    val allBudgetGoals: Flow<List<BudgetGoal>> = database.budgetGoalDao().getAllBudgetGoals()

    suspend fun insertBudgetGoal(goal: BudgetGoal) {
        database.budgetGoalDao().insertBudgetGoal(goal)
    }

    suspend fun updateBudgetGoal(goal: BudgetGoal) {
        database.budgetGoalDao().updateBudgetGoal(goal)
    }

    suspend fun deleteBudgetGoal(goal: BudgetGoal) {
        database.budgetGoalDao().deleteBudgetGoal(goal)
    }
}
