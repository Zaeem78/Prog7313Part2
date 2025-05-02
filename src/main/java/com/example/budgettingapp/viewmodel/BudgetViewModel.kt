package com.example.budgettingapp.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.budgettingapp.data.Expense
import com.example.budgettingapp.data.Goal
import com.example.budgettingapp.database.BudgetDatabaseHelper
import kotlinx.coroutines.launch

class BudgetViewModel(application: Application) : AndroidViewModel(application) {
    private val context: Context = application.applicationContext
    private val database = BudgetDatabaseHelper(context)
    
    private val _expenses = MutableLiveData<List<Expense>>(emptyList())
    val expenses: LiveData<List<Expense>> = _expenses
    
    private val _goals = MutableLiveData<List<Goal>>(emptyList())
    val goals: LiveData<List<Goal>> = _goals
    
    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading
    
    private val _error = MutableLiveData<String?>(null)
    val error: LiveData<String?> = _error

    init {
        loadExpenses()
        loadGoals()
    }

    private fun loadExpenses() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _expenses.value = database.getAllExpenses()
                _error.value = null
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }

    private fun loadGoals() {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                _goals.value = database.getAllGoals()
                _error.value = null
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun insertExpense(expense: Expense) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                database.insertExpense(expense)
                _expenses.value = database.getAllExpenses()
                _error.value = null
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun updateExpense(expense: Expense) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                database.updateExpense(expense)
                _expenses.value = database.getAllExpenses()
                _error.value = null
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun deleteExpense(expense: Expense) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                database.deleteExpense(expense)
                _expenses.value = database.getAllExpenses()
                _error.value = null
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun insertGoal(goal: Goal) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                database.insertGoal(goal)
                _goals.value = database.getAllGoals()
                _error.value = null
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun updateGoal(goal: Goal) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                database.updateGoal(goal)
                _goals.value = database.getAllGoals()
                _error.value = null
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun deleteGoal(goal: Goal) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                database.deleteGoal(goal)
                _goals.value = database.getAllGoals()
                _error.value = null
            } catch (e: Exception) {
                _error.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
}
