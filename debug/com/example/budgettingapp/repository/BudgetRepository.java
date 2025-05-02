package com.example.budgettingapp.repository;

import com.example.budgettingapp.database.BudgetDatabase;
import com.example.budgettingapp.data.Expense;
import com.example.budgettingapp.database.dao.ExpenseDao;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0007H\u0086@\u00a2\u0006\u0002\u0010\u0015J\u001e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0086@\u00a2\u0006\u0002\u0010\u001bJ\u0016\u0010\u001c\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u001d\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u000eR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/example/budgettingapp/repository/BudgetRepository;", "", "database", "Lcom/example/budgettingapp/database/BudgetDatabase;", "(Lcom/example/budgettingapp/database/BudgetDatabase;)V", "allExpenses", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/example/budgettingapp/data/Expense;", "getAllExpenses", "()Lkotlinx/coroutines/flow/Flow;", "deleteExpense", "", "expense", "(Lcom/example/budgettingapp/data/Expense;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExpenseById", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getExpensesByCategory", "Lcom/example/budgettingapp/database/dao/ExpenseDao$CategoryTotal;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getTotalExpenses", "", "startDate", "", "endDate", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertExpense", "updateExpense", "app_debug"})
public final class BudgetRepository {
    @org.jetbrains.annotations.NotNull
    private final com.example.budgettingapp.database.BudgetDatabase database = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.Flow<java.util.List<com.example.budgettingapp.data.Expense>> allExpenses = null;
    
    public BudgetRepository(@org.jetbrains.annotations.NotNull
    com.example.budgettingapp.database.BudgetDatabase database) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.example.budgettingapp.data.Expense>> getAllExpenses() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getExpenseById(long id, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.example.budgettingapp.data.Expense> $completion) {
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
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getTotalExpenses(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    java.lang.String endDate, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getExpensesByCategory(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.budgettingapp.database.dao.ExpenseDao.CategoryTotal>> $completion) {
        return null;
    }
}