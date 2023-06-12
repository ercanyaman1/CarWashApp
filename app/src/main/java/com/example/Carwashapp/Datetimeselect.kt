package com.example.Carwashapp

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.widget.DatePicker
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.Carwashapp.paymentpageActivity
import java.util.Calendar

class Datetimeselect : AppCompatActivity() {

    private lateinit var selectedDateTextView: EditText
    private lateinit var timeEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.selectdatetime)

        selectedDateTextView = findViewById(R.id.dateEditText)
        timeEditText = findViewById(R.id.timeEditText)

        findViewById<EditText>(R.id.dateEditText).setOnClickListener {
            showDatePickerDialog()
        }

        findViewById<EditText>(R.id.timeEditText).setOnClickListener {
            showTimePickerDialog()
        }

        val continueButton: Button = findViewById(R.id.continuebtn)
        continueButton.setOnClickListener {
            val selectedDate = selectedDateTextView.text.toString()
            val selectedTime = timeEditText.text.toString()

            if (selectedDate.isNotEmpty() && selectedTime.isNotEmpty()) {
                val intent = Intent(this, paymentpageActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Lütfen tarih ve saat seçiniz.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view: DatePicker, year: Int, monthOfYear: Int, dayOfMonth: Int ->
            val selectedDate = "${dayOfMonth}/${monthOfYear + 1}/${year}"
            val editable: Editable = Editable.Factory.getInstance().newEditable(selectedDate)
            selectedDateTextView.text = editable
        }, year, month, day)

        datePickerDialog.show()
    }

    private fun showTimePickerDialog() {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { view, hourOfDay, minute ->
                val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                timeEditText.setText(selectedTime)
            },
            hour,
            minute,
            true
        )

        timePickerDialog.show()
    }
}
