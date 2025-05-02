package com.example.budgettingapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.budgettingapp.data.DataManager
import com.example.budgettingapp.data.Expense
import com.example.budgettingapp.databinding.ActivityAddExpenseBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.*

class AddExpenseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddExpenseBinding
    private lateinit var dataManager: DataManager
    
    // Constants for date and time formatting
    private val DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE
    private val TIME_FORMATTER = DateTimeFormatter.ISO_LOCAL_TIME
    private val CURRENT_DATE = LocalDateTime.now()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        dataManager = DataManager.getInstance(this)

        setupViews()
    }

    private fun setupViews() {
        // Set current date and time
        binding.etDate.text = DATE_FORMATTER.format(CURRENT_DATE)
        binding.etStartTime.text = TIME_FORMATTER.format(CURRENT_DATE)
        binding.etEndTime.text = TIME_FORMATTER.format(CURRENT_DATE)

        // Set up date picker
        binding.etDate.setOnClickListener {
            showDatePicker()
        }

        // Set up time pickers
        binding.etStartTime.setOnClickListener {
            showTimePicker(binding.etStartTime)
        }

        binding.etEndTime.setOnClickListener {
            showTimePicker(binding.etEndTime)
        }

        // Set up save button
        binding.btnSave.setOnClickListener {
            saveExpense()
        }
    }

    private fun showDatePicker() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            { _, year, month, dayOfMonth ->
                val selectedDate = "$year-${month + 1}-$dayOfMonth"
                binding.etDate.text = selectedDate
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }

    private fun showTimePicker(timeEditText: android.widget.EditText) {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(
            this,
            { _, hourOfDay, minute ->
                val time = String.format("%02d:%02d", hourOfDay, minute)
                timeEditText.text = time
            },
            hour,
            minute,
            true
        )
        timePickerDialog.show()
    }

    private fun saveExpense() {
        val date = binding.etDate.text.toString()
        val startTime = binding.etStartTime.text.toString()
        val endTime = binding.etEndTime.text.toString()
        val description = binding.etDescription.text.toString()
        val category = binding.etCategory.text.toString()
        val amount = binding.etAmount.text.toString().toDoubleOrNull()

        // Validate input
        if (!validateInput(date, startTime, endTime, description, category, amount)) {
            return
        }

        // Parse dates and times
        val parsedDate = parseDate(date)
        val parsedStartTime = parseTime(startTime)
        val parsedEndTime = parseTime(endTime)

        // Validate time range
        if (!validateTimeRange(parsedStartTime, parsedEndTime)) {
            Toast.makeText(this, "End time must be after start time", Toast.LENGTH_SHORT).show()
            return
        }

        val expense = Expense(
            title = description,
            amount = amount,
            category = category,
            date = parsedDate,
            startTime = parsedStartTime,
            endTime = parsedEndTime,
            description = description
        )

        // Save to SharedPreferences using DataManager
        dataManager.saveExpense(expense)
        Toast.makeText(this, "Expense saved successfully", Toast.LENGTH_SHORT).show()
        finish()
    }

    private fun validateInput(
        date: String,
        startTime: String,
        endTime: String,
        description: String,
        category: String,
        amount: Double?
    ): Boolean {
        if (date.isEmpty() || startTime.isEmpty() || endTime.isEmpty() ||
            description.isEmpty() || category.isEmpty() || amount == null) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return false
        }

        if (amount < 0) {
            Toast.makeText(this, "Amount must be positive", Toast.LENGTH_SHORT).show()
            return false
        }

        try {
            // Attempt to parse dates and times to ensure they're valid
            parseDate(date)
            parseTime(startTime)
            parseTime(endTime)
        } catch (e: DateTimeParseException) {
            Toast.makeText(this, "Invalid date or time format", Toast.LENGTH_SHORT).show()
            return false
        }

        return true
    }

    private fun parseDate(dateString: String): LocalDateTime {
        return LocalDateTime.parse(dateString, DATE_FORMATTER)
    }

    private fun parseTime(timeString: String): LocalDateTime {
        return LocalDateTime.parse(timeString, TIME_FORMATTER)
    }

    private fun validateTimeRange(startTime: LocalDateTime, endTime: LocalDateTime): Boolean {
        return startTime.isBefore(endTime)
    }
}
