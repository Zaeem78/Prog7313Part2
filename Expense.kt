package com.example.budgettingapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import androidx.room.TypeConverters
import java.time.LocalDateTime

@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    
    @ColumnInfo(name = "title")
    var title: String,
    
    @ColumnInfo(name = "amount")
    var amount: Double,
    
    @ColumnInfo(name = "category")
    var category: String,
    
    @ColumnInfo(name = "date")
    var date: LocalDateTime,
    
    @ColumnInfo(name = "start_time")
    var startTime: LocalDateTime,
    
    @ColumnInfo(name = "end_time")
    var endTime: LocalDateTime,
    
    @ColumnInfo(name = "description")
    var description: String,
    
    @ColumnInfo(name = "timestamp")
    var timestamp: Long = System.currentTimeMillis()
) {
    constructor() : this(0, "", 0.0, "", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), "", 0)
}
