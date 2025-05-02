package com.example.budgettingapp.database.dao

import androidx.room.*
import com.example.budgettingapp.data.Expense
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenseDao {
    @Query("SELECT * FROM expenses ORDER BY timestamp DESC")
    fun getAllExpenses(): Flow<List<Expense>>

    @Query("SELECT * FROM expenses WHERE id = :id")
    suspend fun getExpenseById(id: Long): Expense?

    @Insert
    suspend fun insertExpense(expense: Expense)

    @Update
    suspend fun updateExpense(expense: Expense)

    @Delete
    suspend fun deleteExpense(expense: Expense)

    @Query("SELECT SUM(amount) FROM expenses WHERE date BETWEEN :startDate AND :endDate")
    suspend fun getTotalExpenses(startDate: String, endDate: String): Double

    @Query("SELECT category, SUM(amount) as total FROM expenses GROUP BY category")
    suspend fun getExpensesByCategory(): List<CategoryTotal>

    data class CategoryTotal(
        val category: String,
        val total: Double
    )
}
