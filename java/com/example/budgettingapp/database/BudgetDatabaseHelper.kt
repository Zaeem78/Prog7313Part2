package com.example.budgettingapp.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.example.budgettingapp.data.Expense
import com.example.budgettingapp.data.Goal
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class BudgetDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    
    object ExpenseEntry : BaseColumns {
        const val TABLE_NAME = "expenses"
        const val COLUMN_TITLE = "title"
        const val COLUMN_AMOUNT = "amount"
        const val COLUMN_CATEGORY = "category"
        const val COLUMN_DATE = "date"
        const val COLUMN_START_TIME = "start_time"
        const val COLUMN_END_TIME = "end_time"
        const val COLUMN_DESCRIPTION = "description"
        const val COLUMN_TIMESTAMP = "timestamp"
    }

    object GoalEntry : BaseColumns {
        const val TABLE_NAME = "goals"
        const val COLUMN_TITLE = "title"
        const val COLUMN_TARGET_AMOUNT = "target_amount"
        const val COLUMN_CURRENT_AMOUNT = "current_amount"
        const val COLUMN_DEADLINE = "deadline"
        const val COLUMN_DESCRIPTION = "description"
        const val COLUMN_TIMESTAMP = "timestamp"
    }

    private val SQL_CREATE_ENTRIES = """
        CREATE TABLE ${ExpenseEntry.TABLE_NAME} (
            ${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT,
            ${ExpenseEntry.COLUMN_TITLE} TEXT NOT NULL,
            ${ExpenseEntry.COLUMN_AMOUNT} REAL NOT NULL,
            ${ExpenseEntry.COLUMN_CATEGORY} TEXT NOT NULL,
            ${ExpenseEntry.COLUMN_DATE} TEXT NOT NULL,
            ${ExpenseEntry.COLUMN_START_TIME} TEXT NOT NULL,
            ${ExpenseEntry.COLUMN_END_TIME} TEXT NOT NULL,
            ${ExpenseEntry.COLUMN_DESCRIPTION} TEXT,
            ${ExpenseEntry.COLUMN_TIMESTAMP} INTEGER NOT NULL
        );
        CREATE TABLE ${GoalEntry.TABLE_NAME} (
            ${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT,
            ${GoalEntry.COLUMN_TITLE} TEXT NOT NULL,
            ${GoalEntry.COLUMN_TARGET_AMOUNT} REAL NOT NULL,
            ${GoalEntry.COLUMN_CURRENT_AMOUNT} REAL NOT NULL,
            ${GoalEntry.COLUMN_DEADLINE} TEXT NOT NULL,
            ${GoalEntry.COLUMN_DESCRIPTION} TEXT,
            ${GoalEntry.COLUMN_TIMESTAMP} INTEGER NOT NULL
        )
    """.trimIndent()

    private val SQL_DELETE_ENTRIES = """
        DROP TABLE IF EXISTS ${ExpenseEntry.TABLE_NAME};
        DROP TABLE IF EXISTS ${GoalEntry.TABLE_NAME}
    """.trimIndent()

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(SQL_CREATE_ENTRIES)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL(SQL_DELETE_ENTRIES)
        onCreate(db)
    }

    companion object {
        const val DATABASE_NAME = "budget_database.db"
        const val DATABASE_VERSION = 2
    }

    private val dateFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME

    fun insertExpense(expense: Expense): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(ExpenseEntry.COLUMN_TITLE, expense.title)
            put(ExpenseEntry.COLUMN_AMOUNT, expense.amount)
            put(ExpenseEntry.COLUMN_CATEGORY, expense.category)
            put(ExpenseEntry.COLUMN_DATE, dateFormatter.format(expense.date))
            put(ExpenseEntry.COLUMN_START_TIME, dateFormatter.format(expense.startTime))
            put(ExpenseEntry.COLUMN_END_TIME, dateFormatter.format(expense.endTime))
            put(ExpenseEntry.COLUMN_DESCRIPTION, expense.description)
            put(ExpenseEntry.COLUMN_TIMESTAMP, expense.timestamp)
        }
        return db.insert(ExpenseEntry.TABLE_NAME, null, values)
    }

    fun updateExpense(expense: Expense): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(ExpenseEntry.COLUMN_TITLE, expense.title)
            put(ExpenseEntry.COLUMN_AMOUNT, expense.amount)
            put(ExpenseEntry.COLUMN_CATEGORY, expense.category)
            put(ExpenseEntry.COLUMN_DATE, dateFormatter.format(expense.date))
            put(ExpenseEntry.COLUMN_START_TIME, dateFormatter.format(expense.startTime))
            put(ExpenseEntry.COLUMN_END_TIME, dateFormatter.format(expense.endTime))
            put(ExpenseEntry.COLUMN_DESCRIPTION, expense.description)
            put(ExpenseEntry.COLUMN_TIMESTAMP, expense.timestamp)
        }
        return db.update(
            ExpenseEntry.TABLE_NAME,
            values,
            "${BaseColumns._ID} = ?",
            arrayOf(expense.id.toString())
        )
    }



    fun insertGoal(goal: Goal): Long {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(GoalEntry.COLUMN_TITLE, goal.title)
            put(GoalEntry.COLUMN_TARGET_AMOUNT, goal.targetAmount)
            put(GoalEntry.COLUMN_CURRENT_AMOUNT, goal.currentAmount)
            put(GoalEntry.COLUMN_DEADLINE, dateFormatter.format(goal.deadline))
            put(GoalEntry.COLUMN_DESCRIPTION, goal.description)
            put(GoalEntry.COLUMN_TIMESTAMP, goal.timestamp)
        }
        return db.insert(GoalEntry.TABLE_NAME, null, values)
    }

    fun updateGoal(goal: Goal): Int {
        val db = writableDatabase
        val values = ContentValues().apply {
            put(GoalEntry.COLUMN_TITLE, goal.title)
            put(GoalEntry.COLUMN_TARGET_AMOUNT, goal.targetAmount)
            put(GoalEntry.COLUMN_CURRENT_AMOUNT, goal.currentAmount)
            put(GoalEntry.COLUMN_DEADLINE, dateFormatter.format(goal.deadline))
            put(GoalEntry.COLUMN_DESCRIPTION, goal.description)
            put(GoalEntry.COLUMN_TIMESTAMP, goal.timestamp)
        }
        return db.update(
            GoalEntry.TABLE_NAME,
            values,
            "${BaseColumns._ID} = ?",
            arrayOf(goal.id.toString())
        )
    }

    fun getAllGoals(): List<Goal> {
        val db = readableDatabase
        val projection = arrayOf(
            BaseColumns._ID,
            GoalEntry.COLUMN_TITLE,
            GoalEntry.COLUMN_TARGET_AMOUNT,
            GoalEntry.COLUMN_CURRENT_AMOUNT,
            GoalEntry.COLUMN_DEADLINE,
            GoalEntry.COLUMN_DESCRIPTION,
            GoalEntry.COLUMN_TIMESTAMP
        )
        val cursor = db.query(
            GoalEntry.TABLE_NAME,
            projection,
            null,
            null,
            null,
            null,
            null
        )
        val goals = mutableListOf<Goal>()
        with(cursor) {
            while (moveToNext()) {
                val goal = Goal(
                    id = getLong(getColumnIndexOrThrow(BaseColumns._ID)),
                    title = getString(getColumnIndexOrThrow(GoalEntry.COLUMN_TITLE)),
                    targetAmount = getDouble(getColumnIndexOrThrow(GoalEntry.COLUMN_TARGET_AMOUNT)),
                    currentAmount = getDouble(getColumnIndexOrThrow(GoalEntry.COLUMN_CURRENT_AMOUNT)),
                    deadline = LocalDateTime.parse(getString(getColumnIndexOrThrow(GoalEntry.COLUMN_DEADLINE)), dateFormatter),
                    description = getString(getColumnIndexOrThrow(GoalEntry.COLUMN_DESCRIPTION)),
                    timestamp = getLong(getColumnIndexOrThrow(GoalEntry.COLUMN_TIMESTAMP))
                )
                goals.add(goal)
            }
        }
        cursor.close()
        return goals
    }

    fun deleteGoal(goal: Goal): Int {
        val db = writableDatabase
        return db.delete(
            GoalEntry.TABLE_NAME,
            "${BaseColumns._ID} = ?",
            arrayOf(goal.id.toString())
        )
    }



    fun deleteExpense(expense: Expense): Int {
        val db = writableDatabase
        val selection = "${BaseColumns._ID} = ?"
        val selectionArgs = arrayOf(expense.id.toString())
        return db.delete(ExpenseEntry.TABLE_NAME, selection, selectionArgs)
    }

    fun getAllExpenses(): List<Expense> {
        val db = readableDatabase
        val cursor = db.query(
            ExpenseEntry.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            "${ExpenseEntry.COLUMN_TIMESTAMP} DESC"
        )
        val expenses = mutableListOf<Expense>()
        with(cursor) {
            while (moveToNext()) {
                val expense = Expense(
                    id = getLong(getColumnIndexOrThrow(BaseColumns._ID)),
                    title = getString(getColumnIndexOrThrow(ExpenseEntry.COLUMN_TITLE)),
                    amount = getDouble(getColumnIndexOrThrow(ExpenseEntry.COLUMN_AMOUNT)),
                    category = getString(getColumnIndexOrThrow(ExpenseEntry.COLUMN_CATEGORY)),
                    date = LocalDateTime.parse(getString(getColumnIndexOrThrow(ExpenseEntry.COLUMN_DATE)), dateFormatter),
                    startTime = LocalDateTime.parse(getString(getColumnIndexOrThrow(ExpenseEntry.COLUMN_START_TIME)), dateFormatter),
                    endTime = LocalDateTime.parse(getString(getColumnIndexOrThrow(ExpenseEntry.COLUMN_END_TIME)), dateFormatter),
                    description = getString(getColumnIndexOrThrow(ExpenseEntry.COLUMN_DESCRIPTION)),
                    timestamp = getLong(getColumnIndexOrThrow(ExpenseEntry.COLUMN_TIMESTAMP))
                )
                expenses.add(expense)
            }
        }
        cursor.close()
        return expenses
    }


    fun getExpenseById(id: Long): Expense? {
        val db = readableDatabase
        val selection = "${BaseColumns._ID} = ?"
        val selectionArgs = arrayOf(id.toString())
        val cursor = db.query(
            ExpenseEntry.TABLE_NAME,
            null,
            selection,
            selectionArgs,
            null,
            null,
            null
        )
        var expense: Expense? = null
        with(cursor) {
            if (moveToNext()) {
                expense = Expense(
                    id = getLong(getColumnIndexOrThrow(BaseColumns._ID)),
                    title = getString(getColumnIndexOrThrow(ExpenseEntry.COLUMN_TITLE)),
                    amount = getDouble(getColumnIndexOrThrow(ExpenseEntry.COLUMN_AMOUNT)),
                    category = getString(getColumnIndexOrThrow(ExpenseEntry.COLUMN_CATEGORY)),
                    date = LocalDateTime.parse(getString(getColumnIndexOrThrow(ExpenseEntry.COLUMN_DATE)), dateFormatter),
                    startTime = LocalDateTime.parse(getString(getColumnIndexOrThrow(ExpenseEntry.COLUMN_START_TIME)), dateFormatter),
                    endTime = LocalDateTime.parse(getString(getColumnIndexOrThrow(ExpenseEntry.COLUMN_END_TIME)), dateFormatter),
                    description = getString(getColumnIndexOrThrow(ExpenseEntry.COLUMN_DESCRIPTION)),
                    timestamp = getLong(getColumnIndexOrThrow(ExpenseEntry.COLUMN_TIMESTAMP))
                )
            }
        }
        cursor.close()
        return expense
    }

    fun getTotalExpenses(startDate: String, endDate: String): Double {
        val db = readableDatabase
        val selection = "${ExpenseEntry.COLUMN_DATE} BETWEEN ? AND ?"
        val selectionArgs = arrayOf(startDate, endDate)
        val cursor = db.rawQuery(
            "SELECT SUM(${ExpenseEntry.COLUMN_AMOUNT}) FROM ${ExpenseEntry.TABLE_NAME} WHERE ${selection}",
            selectionArgs
        )
        var total = 0.0
        with(cursor) {
            if (moveToNext()) {
                total = getDouble(0)
            }
        }
        cursor.close()
        return total
    }

    fun getExpensesByCategory(): List<CategoryTotal> {
        val db = readableDatabase
        val cursor = db.rawQuery(
            "SELECT ${ExpenseEntry.COLUMN_CATEGORY}, SUM(${ExpenseEntry.COLUMN_AMOUNT}) as total FROM ${ExpenseEntry.TABLE_NAME} GROUP BY ${ExpenseEntry.COLUMN_CATEGORY}",
            null
        )
        val totals = mutableListOf<CategoryTotal>()
        with(cursor) {
            while (moveToNext()) {
                totals.add(
                    CategoryTotal(
                        category = getString(getColumnIndexOrThrow(ExpenseEntry.COLUMN_CATEGORY)),
                        total = getDouble(getColumnIndexOrThrow("total"))
                    )
                )
            }
        }
        cursor.close()
        return totals
    }

    data class CategoryTotal(
        val category: String,
        val total: Double
    )
}
