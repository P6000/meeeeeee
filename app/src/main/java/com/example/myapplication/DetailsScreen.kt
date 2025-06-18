package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val minTemps = intent.getIntArrayExtra("minTemps")!!
        val maxTemps = intent.getIntArrayExtra("maxTemps")!!
        val conditions = intent.getStringArrayExtra("conditions")!!

        val txtDetails = findViewById<TextView>(R.id.txtDetails)
        val sb = StringBuilder()
        val days = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

        for (i in days.indices) {
            sb.append("${days[i]}: Min ${minTemps[i]}°C, Max ${maxTemps[i]}°C, ${conditions[i]}\n")
        }

        txtDetails.text = sb.toString()
    }
}