package com.example.budgettingapp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import java.time.LocalDateTime

@Dao
interface ExpenseDao {
    @Query("SELECT * FROM expenses ORDER BY date DESC")
    fun getAllExpenses(): Flow<List<Expense>>

    @Query("SELECT * FROM expenses WHERE date BETWEEN :startDate AND :endDate ORDER BY date DESC")
    fun getExpensesByDateRange(startDate: LocalDateTime, endDate: LocalDateTime): Flow<List<Expense>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExpense(expense: Expense)

    @Update
    suspend fun updateExpense(expense: Expense)

    @Delete
    suspend fun deleteExpense(expense: Expense)

    @Query("DELETE FROM expenses")
    suspend fun deleteAllExpenses()

    @Query("SELECT category, SUM(amount) as total FROM expenses GROUP BY category")
    fun getExpensesByCategory(): Flow<List<CategoryTotal>>

    @Query("SELECT SUM(amount) as total FROM expenses WHERE date BETWEEN :startDate AND :endDate")
    suspend fun getTotalExpenses(startDate: String, endDate: String): Double

    @Query("SELECT * FROM expenses WHERE id = :id")
    suspend fun getExpenseById(id: Long): Expense?

    data class CategoryTotal(
        val category: String,
        val total: Double
    )
}
