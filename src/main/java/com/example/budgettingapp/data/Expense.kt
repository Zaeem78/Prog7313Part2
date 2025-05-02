package com.example.budgettingapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import androidx.room.TypeConverters
import java.time.LocalDateTime
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "expenses")
data class Expense(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    
    @ColumnInfo(name = "title")
    var title: String,
    
    @ColumnInfo(name = "amount")
    var amount: Double = 0.0,
    
    @ColumnInfo(name = "category")
    var category: String,
    
    @ColumnInfo(name = "date")
    var date: LocalDateTime = LocalDateTime.now(),
    
    @ColumnInfo(name = "start_time")
    var startTime: LocalDateTime = LocalDateTime.now(),
    
    @ColumnInfo(name = "end_time")
    var endTime: LocalDateTime = LocalDateTime.now(),
    
    @ColumnInfo(name = "description")
    var description: String = "",

    @ColumnInfo(name = "image_url")
    var imageUrl: String? = null,
    
    @ColumnInfo(name = "timestamp")
    var timestamp: Long = System.currentTimeMillis()
) : Parcelable {
    constructor() : this(0, "", 0.0, "", LocalDateTime.now(), LocalDateTime.now(), LocalDateTime.now(), "", null, 0)

    fun getTotalAmount(): Double {
        return amount
    }
}
