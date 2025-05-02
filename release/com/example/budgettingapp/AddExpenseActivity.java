package com.example.budgettingapp;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.budgettingapp.data.DataManager;
import com.example.budgettingapp.data.Expense;
import com.example.budgettingapp.databinding.ActivityAddExpenseBinding;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u000eH\u0002J\b\u0010\u001a\u001a\u00020\u000eH\u0002J\b\u0010\u001b\u001a\u00020\u000eH\u0002J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J8\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00142\u0006\u0010&\u001a\u00020\u0014H\u0002J\u0018\u0010\'\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u0004H\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00070\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/example/budgettingapp/AddExpenseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "CURRENT_DATE", "Ljava/time/LocalDateTime;", "kotlin.jvm.PlatformType", "DATE_FORMATTER", "Ljava/time/format/DateTimeFormatter;", "TIME_FORMATTER", "binding", "Lcom/example/budgettingapp/databinding/ActivityAddExpenseBinding;", "dataManager", "Lcom/example/budgettingapp/data/DataManager;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "parseDate", "Ljava/time/LocalDate;", "dateString", "", "parseDateTime", "timeString", "parseTime", "Ljava/time/LocalTime;", "saveExpense", "setupViews", "showDatePicker", "showTimePicker", "timeEditText", "Landroid/widget/EditText;", "validateInput", "", "date", "startTime", "endTime", "description", "category", "amountText", "validateTimeRange", "app_release"})
public final class AddExpenseActivity extends androidx.appcompat.app.AppCompatActivity {
    private com.example.budgettingapp.databinding.ActivityAddExpenseBinding binding;
    private com.example.budgettingapp.data.DataManager dataManager;
    private final java.time.format.DateTimeFormatter DATE_FORMATTER = null;
    private final java.time.format.DateTimeFormatter TIME_FORMATTER = null;
    private final java.time.LocalDateTime CURRENT_DATE = null;
    
    public AddExpenseActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupViews() {
    }
    
    private final void showDatePicker() {
    }
    
    private final void showTimePicker(android.widget.EditText timeEditText) {
    }
    
    private final void saveExpense() {
    }
    
    private final boolean validateInput(java.lang.String date, java.lang.String startTime, java.lang.String endTime, java.lang.String description, java.lang.String category, java.lang.String amountText) {
        return false;
    }
    
    private final java.time.LocalDateTime parseDateTime(java.lang.String dateString, java.lang.String timeString) {
        return null;
    }
    
    private final java.time.LocalDate parseDate(java.lang.String dateString) {
        return null;
    }
    
    private final java.time.LocalTime parseTime(java.lang.String timeString) {
        return null;
    }
    
    private final boolean validateTimeRange(java.time.LocalDateTime startTime, java.time.LocalDateTime endTime) {
        return false;
    }
}