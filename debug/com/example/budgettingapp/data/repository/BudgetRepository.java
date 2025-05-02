package com.example.budgettingapp.data.repository;

import androidx.lifecycle.LiveData;
import com.example.budgettingapp.data.Expense;
import com.example.budgettingapp.data.BudgetGoal;
import com.example.budgettingapp.data.BudgetDatabase;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\u0018J\u0016\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u0015J\u0016\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\u0018R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001d"}, d2 = {"Lcom/example/budgettingapp/data/repository/BudgetRepository;", "", "database", "Lcom/example/budgettingapp/data/BudgetDatabase;", "(Lcom/example/budgettingapp/data/BudgetDatabase;)V", "allBudgetGoals", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/budgettingapp/data/BudgetGoal;", "getAllBudgetGoals", "()Lkotlinx/coroutines/flow/Flow;", "allExpenses", "Lcom/example/budgettingapp/data/Expense;", "getAllExpenses", "budgetGoalDao", "Lcom/example/budgettingapp/data/BudgetGoalDao;", "expenseDao", "Lcom/example/budgettingapp/data/ExpenseDao;", "deleteBudgetGoal", "", "goal", "(Lcom/example/budgettingapp/data/BudgetGoal;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteExpense", "expense", "(Lcom/example/budgettingapp/data/Expense;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertBudgetGoal", "insertExpense", "updateBudgetGoal", "updateExpense", "app_debug"})
public final class BudgetRepository {
    @org.jetbrains.annotations.NotNull
    private final com.example.budgettingapp.data.BudgetDatabase database = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.budgettingapp.data.ExpenseDao expenseDao = null;
    @org.jetbrains.annotations.NotNull
    private final com.example.budgettingapp.data.BudgetGoalDao budgetGoalDao = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.budgettingapp.data.Expense>> allExpenses = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.budgettingapp.data.BudgetGoal>> allBudgetGoals = null;
    
    public BudgetRepository(@org.jetbrains.annotations.NotNull
    com.example.budgettingapp.data.BudgetDatabase database) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.budgettingapp.data.Expense>> getAllExpenses() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertExpense(@org.jetbrains.annotations.NotNull
    com.example.budgettingapp.data.Expense expense, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateExpense(@org.jetbrains.annotations.NotNull
    com.example.budgettingapp.data.Expense expense, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteExpense(@org.jetbrains.annotations.NotNull
    com.example.budgettingapp.data.Expense expense, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.budgettingapp.data.BudgetGoal>> getAllBudgetGoals() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object insertBudgetGoal(@org.jetbrains.annotations.NotNull
    com.example.budgettingapp.data.BudgetGoal goal, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object updateBudgetGoal(@org.jetbrains.annotations.NotNull
    com.example.budgettingapp.data.BudgetGoal goal, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object deleteBudgetGoal(@org.jetbrains.annotations.NotNull
    com.example.budgettingapp.data.BudgetGoal goal, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}