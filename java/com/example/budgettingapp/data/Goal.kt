package com.example.budgettingapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ColumnInfo
import androidx.room.TypeConverters
import java.time.LocalDateTime
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "goals")
data class Goal(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    
    @ColumnInfo(name = "title")
    var title: String,
    
    @ColumnInfo(name = "target_amount")
    var targetAmount: Double = 0.0,
    
    @ColumnInfo(name = "current_amount")
    var currentAmount: Double = 0.0,
    
    @ColumnInfo(name = "deadline")
    var deadline: LocalDateTime = LocalDateTime.now(),
    
    @ColumnInfo(name = "description")
    var description: String = "",

    @ColumnInfo(name = "timestamp")
    var timestamp: Long = System.currentTimeMillis()
) : Parcelable {
    constructor() : this(0, "", 0.0, 0.0, LocalDateTime.now(), "", 0)

    fun getProgressPercentage(): Double {
        return if (targetAmount == 0.0) 0.0 else (currentAmount / targetAmount) * 100
    }
}
