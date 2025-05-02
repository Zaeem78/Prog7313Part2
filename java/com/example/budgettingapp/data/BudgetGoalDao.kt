package com.example.budgettingapp.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface BudgetGoalDao {
    @Query("SELECT * FROM budget_goals ORDER BY endDate ASC")
    fun getAllBudgetGoals(): Flow<List<BudgetGoal>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertBudgetGoal(goal: BudgetGoal)

    @Update
    suspend fun updateBudgetGoal(goal: BudgetGoal)

    @Delete
    suspend fun deleteBudgetGoal(goal: BudgetGoal)

    @Query("DELETE FROM budget_goals")
    suspend fun deleteAllBudgetGoals()
}
