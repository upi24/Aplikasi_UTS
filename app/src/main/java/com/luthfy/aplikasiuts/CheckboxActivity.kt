package com.luthfy.aplikasiuts

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class CheckboxActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkbox)

        val nameEditText: EditText = findViewById(R.id.nameEditText)
        val emailEditText: EditText = findViewById(R.id.emailEditText)
        val termsCheckBox: CheckBox = findViewById(R.id.termsCheckBox)
        val genderRadioGroup: RadioGroup = findViewById(R.id.genderRadioGroup)
        val submitButton: Button = findViewById(R.id.submitButton)

        submitButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val genderId = genderRadioGroup.checkedRadioButtonId
            val gender = if (genderId == R.id.maleRadioButton) "Male" else "Female"

            if (termsCheckBox.isChecked) {
                val message = "Name: $name\nEmail: $email\nGender: $gender"
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "You must agree to the terms", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
