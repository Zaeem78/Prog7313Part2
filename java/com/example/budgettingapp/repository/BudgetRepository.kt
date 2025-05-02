package com.example.budgettingapp.repository

import com.example.budgettingapp.database.BudgetDatabase
import com.example.budgettingapp.data.Expense
import com.example.budgettingapp.database.dao.ExpenseDao
import kotlinx.coroutines.flow.Flow

class BudgetRepository(private val database: BudgetDatabase) {
    val allExpenses: Flow<List<Expense>> = database.expenseDao().getAllExpenses()

    suspend fun getExpenseById(id: Long): Expense? {
        return database.expenseDao().getExpenseById(id)
    }

    suspend fun insertExpense(expense: Expense) {
        database.expenseDao().insertExpense(expense)
    }

    suspend fun updateExpense(expense: Expense) {
        database.expenseDao().updateExpense(expense)
    }

    suspend fun deleteExpense(expense: Expense) {
        database.expenseDao().deleteExpense(expense)
    }

    suspend fun getTotalExpenses(startDate: String, endDate: String): Double {
        return database.expenseDao().getTotalExpenses(startDate, endDate)
    }

    suspend fun getExpensesByCategory(): List<ExpenseDao.CategoryTotal> {
        return database.expenseDao().getExpensesByCategory()
    }
}
