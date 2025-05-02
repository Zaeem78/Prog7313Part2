package com.example.budgettingapp.data;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u0018J\u000e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0012J\u000e\u0010\u001b\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u001c\u001a\u00020\u000e2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00100\u0018H\u0002J\u000e\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/example/budgettingapp/data/DataManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "DATE_FORMATTER", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "TIME_FORMATTER", "gson", "Lcom/google/gson/Gson;", "prefs", "Landroid/content/SharedPreferences;", "deleteExpense", "", "expense", "Lcom/example/budgettingapp/data/Expense;", "formatDateTime", "", "dateTime", "Ljava/time/LocalDateTime;", "generateId", "", "getExpenses", "", "parseDateTime", "dateString", "saveExpense", "saveExpenses", "expenses", "updateExpense", "Companion", "app_release"})
public final class DataManager {
    @org.jetbrains.annotations.NotNull
    private final android.content.SharedPreferences prefs = null;
    @org.jetbrains.annotations.NotNull
    private final com.google.gson.Gson gson = null;
    private final java.time.format.DateTimeFormatter DATE_FORMATTER = null;
    private final java.time.format.DateTimeFormatter TIME_FORMATTER = null;
    @org.jetbrains.annotations.Nullable
    private static com.example.budgettingapp.data.DataManager instance;
    @org.jetbrains.annotations.NotNull
    public static final com.example.budgettingapp.data.DataManager.Companion Companion = null;
    
    private DataManager(android.content.Context context) {
        super();
    }
    
    public final void saveExpense(@org.jetbrains.annotations.NotNull
    com.example.budgettingapp.data.Expense expense) {
    }
    
    public final void updateExpense(@org.jetbrains.annotations.NotNull
    com.example.budgettingapp.data.Expense expense) {
    }
    
    public final void deleteExpense(@org.jetbrains.annotations.NotNull
    com.example.budgettingapp.data.Expense expense) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.util.List<com.example.budgettingapp.data.Expense> getExpenses() {
        return null;
    }
    
    private final void saveExpenses(java.util.List<com.example.budgettingapp.data.Expense> expenses) {
    }
    
    public final long generateId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String formatDateTime(@org.jetbrains.annotations.NotNull
    java.time.LocalDateTime dateTime) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.time.LocalDateTime parseDateTime(@org.jetbrains.annotations.NotNull
    java.lang.String dateString) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/example/budgettingapp/data/DataManager$Companion;", "", "()V", "instance", "Lcom/example/budgettingapp/data/DataManager;", "getInstance", "context", "Landroid/content/Context;", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull
        public final com.example.budgettingapp.data.DataManager getInstance(@org.jetbrains.annotations.NotNull
        android.content.Context context) {
            return null;
        }
    }
}