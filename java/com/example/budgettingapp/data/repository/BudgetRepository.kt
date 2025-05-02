package com.example.budgettingapp.data.repository

import androidx.lifecycle.LiveData
import com.example.budgettingapp.data.Expense
import com.example.budgettingapp.data.BudgetGoal
import com.example.budgettingapp.data.BudgetDatabase
import kotlinx.coroutines.flow.Flow

class BudgetRepository(private val database: BudgetDatabase) {
    private val expenseDao = database.expenseDao()
    private val budgetGoalDao = database.budgetGoalDao()

    // Expenses
    val allExpenses: Flow<List<Expense>> = expenseDao.getAllExpenses()

    suspend fun insertExpense(expense: Expense) {
        expenseDao.insertExpense(expense)
    }

    suspend fun updateExpense(expense: Expense) {
        expenseDao.updateExpense(expense)
    }

    suspend fun deleteExpense(expense: Expense) {
        expenseDao.deleteExpense(expense)
    }

    // Budget Goals
    val allBudgetGoals: Flow<List<BudgetGoal>> = budgetGoalDao.getAllBudgetGoals()

    suspend fun insertBudgetGoal(goal: BudgetGoal) {
        budgetGoalDao.insertBudgetGoal(goal)
    }

    suspend fun updateBudgetGoal(goal: BudgetGoal) {
        budgetGoalDao.updateBudgetGoal(goal)
    }

    suspend fun deleteBudgetGoal(goal: BudgetGoal) {
        budgetGoalDao.deleteBudgetGoal(goal)
    }
}
