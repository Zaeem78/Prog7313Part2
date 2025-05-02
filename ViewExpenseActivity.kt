package com.example.budgettingapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog
import com.example.budgettingapp.databinding.ActivityViewExpenseBinding
import com.example.budgettingapp.data.Expense
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.google.firebase.firestore.FirebaseFirestore
import com.squareup.picasso.Picasso
import android.widget.Toast
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle
import java.util.Locale

class ViewExpenseActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewExpenseBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var expense: Expense

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewExpenseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = Firebase.auth

        setupViews()
    }

    private fun setupViews() {
        expense = intent.getParcelableExtra("expense")!!

        binding.btnEdit.setOnClickListener {
            val intent = Intent(this, AddExpenseActivity::class.java)
            intent.putExtra("expense", expense)
            startActivity(intent)
        }

        binding.btnDelete.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Delete Expense")
            builder.setMessage("Are you sure you want to delete this expense?")
            builder.setPositiveButton("Delete") { _, _ ->
                deleteExpense(expense)
            }
            builder.setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            builder.show()
        }

        binding.tvDate.text = formatDate(expense.date)
        binding.tvStartTime.text = formatTime(expense.startTime)
        binding.tvEndTime.text = formatTime(expense.endTime)
        binding.tvDescription.text = expense.description
        binding.tvCategory.text = expense.category
        binding.tvAmount.text = "${expense.amount}"

        expense.imageUrl?.let {
            Picasso.get()
                .load(it)
                .into(binding.ivPhoto)
        }
    }

    private fun deleteExpense(expense: Expense) {
        val db = Firebase.firestore
        val user = auth.currentUser

        if (user != null) {
            db.collection("expenses")
                .document(expense.id.toString())
                .delete()
                .addOnSuccessListener {
                    Toast.makeText(this, "Expense deleted successfully", Toast.LENGTH_SHORT).show()
                    finish()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Error deleting expense: ${e.message}", Toast.LENGTH_SHORT).show()
                }
        }
    }

    private fun formatDate(date: LocalDateTime): String {
        return DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM)
            .withLocale(Locale.getDefault())
            .format(date)
    }

    private fun formatTime(time: LocalDateTime): String {
        return DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)
            .withLocale(Locale.getDefault())
            .format(time)
    }
}
