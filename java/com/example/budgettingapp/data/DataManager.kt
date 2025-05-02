package com.example.budgettingapp.data

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class DataManager private constructor(context: Context) {
    private val prefs: SharedPreferences = context.getSharedPreferences("BudgetPrefs", Context.MODE_PRIVATE)
    private val gson = Gson()
    
    // Constants for date and time formatting
    private val DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    private val TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm")

    companion object {
        private var instance: DataManager? = null
        
        fun getInstance(context: Context): DataManager {
            return instance ?: synchronized(this) {
                val inst = DataManager(context)
                instance = inst
                inst
            }
        }
    }

    // Expense operations
    fun saveExpense(expense: Expense) {
        val expenses = getExpenses().toMutableList()
        expenses.add(expense)
        saveExpenses(expenses)
    }

    fun updateExpense(expense: Expense) {
        val expenses = getExpenses().toMutableList()
        val index = expenses.indexOfFirst { it.id == expense.id }
        if (index != -1) {
            expenses[index] = expense
            saveExpenses(expenses)
        }
    }

    fun deleteExpense(expense: Expense) {
        val expenses = getExpenses().toMutableList()
        expenses.removeIf { it.id == expense.id }
        saveExpenses(expenses)
    }

    fun getExpenses(): List<Expense> {
        val json = prefs.getString("expenses", "[]")
        return gson.fromJson(json, object : TypeToken<List<Expense>>() {}.type)
    }

    private fun saveExpenses(expenses: List<Expense>) {
        val json = gson.toJson(expenses)
        prefs.edit().putString("expenses", json).apply()
    }

    // Helper functions
    fun generateId(): Long {
        return System.currentTimeMillis()
    }

    fun formatDateTime(dateTime: LocalDateTime): String {
        return DATE_FORMATTER.format(dateTime)
    }

    fun parseDateTime(dateString: String): LocalDateTime {
        return LocalDateTime.parse(dateString, DATE_FORMATTER)
    }
}
