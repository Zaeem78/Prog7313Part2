package com.example.budgettingapp.data;

import androidx.room.*;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u000b0\nH\'J\u0016\u0010\f\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\r\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\u00a7@\u00a2\u0006\u0002\u0010\b\u00a8\u0006\u000e"}, d2 = {"Lcom/example/budgettingapp/data/BudgetGoalDao;", "", "deleteAllBudgetGoals", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteBudgetGoal", "goal", "Lcom/example/budgettingapp/data/BudgetGoal;", "(Lcom/example/budgettingapp/data/BudgetGoal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllBudgetGoals", "Lkotlinx/coroutines/flow/Flow;", "", "insertBudgetGoal", "updateBudgetGoal", "app_release"})
@androidx.room.Dao
public abstract interface BudgetGoalDao {
    
    @androidx.room.Query(value = "SELECT * FROM budget_goals ORDER BY endDate ASC")
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.example.budgettingapp.data.BudgetGoal>> getAllBudgetGoals();
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object insertBudgetGoal(@org.jetbrains.annotations.NotNull
    com.example.budgettingapp.data.BudgetGoal goal, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Update
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateBudgetGoal(@org.jetbrains.annotations.NotNull
    com.example.budgettingapp.data.BudgetGoal goal, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteBudgetGoal(@org.jetbrains.annotations.NotNull
    com.example.budgettingapp.data.BudgetGoal goal, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM budget_goals")
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object deleteAllBudgetGoals(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}