package com.luthfy.aplikasiuts

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import android.widget.TextView
import net.objecthunter.exp4j.ExpressionBuilder

class KalkulatorActivity : AppCompatActivity() {

    private lateinit var tvFormula: TextView
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kalkulator)

        tvFormula = findViewById(R.id.tvFormula)
        tvResult = findViewById(R.id.tvResult)

        // Add button click listeners here
        val buttons = listOf(
            R.id.clear, R.id.plus, R.id.divide, R.id.seven, R.id.eight, R.id.nine,
            R.id.multiply, R.id.four, R.id.five, R.id.six, R.id.minus, R.id.one,
            R.id.two, R.id.three, R.id.equals, R.id.zero, R.id.dot, R.id.modulo
        )

        for (id in buttons) {
            findViewById<MaterialButton>(id).setOnClickListener {
                onButtonClick(it as MaterialButton)
            }
        }
    }

    private fun onButtonClick(button: MaterialButton) {
        val buttonText = button.text.toString()
        // Handle button click logic here
        when (buttonText) {
            "C" -> {
                tvFormula.text = ""
                tvResult.text = "0"
            }
            "=" -> calculateResult()
            else -> {
                tvFormula.append(buttonText)
            }
        }
    }

    private fun calculateResult() {
        val formula = tvFormula.text.toString()
        try {
            val expression = ExpressionBuilder(formula).build()
            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                tvResult.text = longResult.toString()
            } else {
                tvResult.text = result.toString()
            }
        } catch (e: Exception) {
            tvResult.text = "Error"
        }
    }
}
