package com.example.budgettingapp.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import com.example.budgettingapp.data.Expense;
import com.example.budgettingapp.data.Goal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 *2\u00020\u0001:\u0004)*+,B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013J\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0013J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0016\u001a\u00020\u0017J\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0013J\u0016\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006J\u000e\u0010\u001e\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u001f\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J \u0010$\u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\fH\u0016J\u000e\u0010\'\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010(\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006-"}, d2 = {"Lcom/example/budgettingapp/database/BudgetDatabaseHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "SQL_CREATE_ENTRIES", "", "SQL_DELETE_ENTRIES", "dateFormatter", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "deleteExpense", "", "expense", "Lcom/example/budgettingapp/data/Expense;", "deleteGoal", "goal", "Lcom/example/budgettingapp/data/Goal;", "getAllExpenses", "", "getAllGoals", "getExpenseById", "id", "", "getExpensesByCategory", "Lcom/example/budgettingapp/database/BudgetDatabaseHelper$CategoryTotal;", "getTotalExpenses", "", "startDate", "endDate", "insertExpense", "insertGoal", "onCreate", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "oldVersion", "newVersion", "updateExpense", "updateGoal", "CategoryTotal", "Companion", "ExpenseEntry", "GoalEntry", "app_release"})
public final class BudgetDatabaseHelper extends android.database.sqlite.SQLiteOpenHelper {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String SQL_CREATE_ENTRIES = null;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String SQL_DELETE_ENTRIES = null;
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String DATABASE_NAME = "budget_database.db";
    public static final int DATABASE_VERSION = 2;
    private final java.time.format.DateTimeFormatter dateFormatter = null;
    @org.jetbrains.annotations.NotNull
    public static final com.example.budgettingapp.database.BudgetDatabaseHelper.Companion Companion = null;
    
    public BudgetDatabaseHelper(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        super(null, null, null, 0);
    }
    
    @java.lang.Override
    public void onCreate(@org.jetbrains.annotations.NotNull
    android.database.sqlite.SQLiteDatabase db) {
    }
    
    @java.lang.Override
    public void onUpgrade(@org.jetbrains.annotations.NotNull
    android.database.sqlite.SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    
    public final long insertExpense(@org.jetbrains.annotations.NotNull
    com.example.budgettingapp.data.Expense expense) {
        return 0L;
    }
    
    public final int updateExpense(@org.jetbrains.annotations.NotNull
    com.example.budgettingapp.data.Expense expense) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.budgettingapp.data.Expense> getAllExpenses() {
        return null;
    }
    
    public final long insertGoal(@org.jetbrains.annotations.NotNull
    com.example.budgettingapp.data.Goal goal) {
        return 0L;
    }
    
    public final int updateGoal(@org.jetbrains.annotations.NotNull
    com.example.budgettingapp.data.Goal goal) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.budgettingapp.data.Goal> getAllGoals() {
        return null;
    }
    
    public final int deleteGoal(@org.jetbrains.annotations.NotNull
    com.example.budgettingapp.data.Goal goal) {
        return 0;
    }
    
    public final int deleteExpense(@org.jetbrains.annotations.NotNull
    com.example.budgettingapp.data.Expense expense) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.budgettingapp.data.Expense> getAllExpenses() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.example.budgettingapp.data.Expense getExpenseById(long id) {
        return null;
    }
    
    public final double getTotalExpenses(@org.jetbrains.annotations.NotNull
    java.lang.String startDate, @org.jetbrains.annotations.NotNull
    java.lang.String endDate) {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.budgettingapp.database.BudgetDatabaseHelper.CategoryTotal> getExpensesByCategory() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0011\u001a\u00020\u0012H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0014"}, d2 = {"Lcom/example/budgettingapp/database/BudgetDatabaseHelper$CategoryTotal;", "", "category", "", "total", "", "(Ljava/lang/String;D)V", "getCategory", "()Ljava/lang/String;", "getTotal", "()D", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_release"})
    public static final class CategoryTotal {
        @org.jetbrains.annotations.NotNull
        private final java.lang.String category = null;
        private final double total = 0.0;
        
        public CategoryTotal(@org.jetbrains.annotations.NotNull
        java.lang.String category, double total) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String getCategory() {
            return null;
        }
        
        public final double getTotal() {
            return 0.0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final java.lang.String component1() {
            return null;
        }
        
        public final double component2() {
            return 0.0;
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.budgettingapp.database.BudgetDatabaseHelper.CategoryTotal copy(@org.jetbrains.annotations.NotNull
        java.lang.String category, double total) {
            return null;
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/example/budgettingapp/database/BudgetDatabaseHelper$Companion;", "", "()V", "DATABASE_NAME", "", "DATABASE_VERSION", "", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/example/budgettingapp/database/BudgetDatabaseHelper$ExpenseEntry;", "Landroid/provider/BaseColumns;", "()V", "COLUMN_AMOUNT", "", "COLUMN_CATEGORY", "COLUMN_DATE", "COLUMN_DESCRIPTION", "COLUMN_END_TIME", "COLUMN_START_TIME", "COLUMN_TIMESTAMP", "COLUMN_TITLE", "TABLE_NAME", "app_release"})
    public static final class ExpenseEntry implements android.provider.BaseColumns {
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String TABLE_NAME = "expenses";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String COLUMN_TITLE = "title";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String COLUMN_AMOUNT = "amount";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String COLUMN_CATEGORY = "category";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String COLUMN_DATE = "date";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String COLUMN_START_TIME = "start_time";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String COLUMN_END_TIME = "end_time";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String COLUMN_DESCRIPTION = "description";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String COLUMN_TIMESTAMP = "timestamp";
        @org.jetbrains.annotations.NotNull
        public static final com.example.budgettingapp.database.BudgetDatabaseHelper.ExpenseEntry INSTANCE = null;
        
        private ExpenseEntry() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/example/budgettingapp/database/BudgetDatabaseHelper$GoalEntry;", "Landroid/provider/BaseColumns;", "()V", "COLUMN_CURRENT_AMOUNT", "", "COLUMN_DEADLINE", "COLUMN_DESCRIPTION", "COLUMN_TARGET_AMOUNT", "COLUMN_TIMESTAMP", "COLUMN_TITLE", "TABLE_NAME", "app_release"})
    public static final class GoalEntry implements android.provider.BaseColumns {
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String TABLE_NAME = "goals";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String COLUMN_TITLE = "title";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String COLUMN_TARGET_AMOUNT = "target_amount";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String COLUMN_CURRENT_AMOUNT = "current_amount";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String COLUMN_DEADLINE = "deadline";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String COLUMN_DESCRIPTION = "description";
        @org.jetbrains.annotations.NotNull
        public static final java.lang.String COLUMN_TIMESTAMP = "timestamp";
        @org.jetbrains.annotations.NotNull
        public static final com.example.budgettingapp.database.BudgetDatabaseHelper.GoalEntry INSTANCE = null;
        
        private GoalEntry() {
            super();
        }
    }
}