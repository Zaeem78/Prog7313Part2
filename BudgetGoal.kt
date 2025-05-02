package com.example.budgettingapp.data

data class BudgetGoal(
    var id: Long = 0,
    var title: String,
    var targetAmount: Double,
    var currentAmount: Double = 0.0,
    var startDate: Long,
    var endDate: Long,
    var description: String? = null,
    var category: String
) {
    constructor() : this(0, "", 0.0, 0.0, 0L, 0L, null, "")
}
