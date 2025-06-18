package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainScreen: AppCompatActivity() {

    val days = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    val minTemps = IntArray(7)
    val maxTemps = IntArray(7)
    val conditions = Array(7) { "" }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mainscreen)

        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val btnDetails = findViewById<Button>(R.id.btnDetails)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val btnExit = findViewById<Button>(R.id.btnExit)
        val txtAverage = findViewById<TextView>(R.id.txtAverage)

        btnCalculate.setOnClickListener {
            var sum = 0
            for (i in 0..6) {
                val max = maxTemps[i]
                sum += max
            }
            val avg = sum / 7
            txtAverage.text = "Average Max Temperature: $avg°C"
        }

        btnDetails.setOnClickListener {
            val intent = Intent(this, DetailsScreen::class.java)
            intent.putExtra("minTemps", minTemps)
            intent.putExtra("maxTemps", maxTemps)
            intent.putExtra("conditions", conditions)
            startActivity(intent)
        }

        btnClear.setOnClickListener {
            for (i in 0..6) {
                minTemps[i] = 0
                maxTemps[i] = 0
                conditions[i] = ""
            }
            txtAverage.text = ""
            Toast.makeText(this, "Data Cleared", Toast.LENGTH_SHORT).show()
        }

        btnExit.setOnClickListener {
            finish()
        }
    }
}