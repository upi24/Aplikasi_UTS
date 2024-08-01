package com.luthfy.aplikasiuts

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BMIActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)

        val weightInput: EditText = findViewById(R.id.weightInput)
        val heightInput: EditText = findViewById(R.id.heightInput)
        val calculateButton: Button = findViewById(R.id.calculateButton)
        val resultTextView: TextView = findViewById(R.id.result)

        calculateButton.setOnClickListener {
            val weight = weightInput.text.toString().toFloatOrNull()
            val height = heightInput.text.toString().toFloatOrNull()

            if (weight != null && height != null) {
                // Convert height from cm to meters
                val heightInMeters = height / 100
                // Calculate BMI
                val bmi = weight / (heightInMeters * heightInMeters)
                // Display result
                resultTextView.text = "Your BMI is %.2f".format(bmi)
            } else {
                resultTextView.text = "Please enter valid weight and height"
            }
        }
    }
}
