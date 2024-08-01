package com.luthfy.aplikasiuts

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.google.android.material.snackbar.Snackbar
import java.util.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        // Find the CardView by its ID
        val kalkulatorCard: CardView = view.findViewById(R.id.kalkulatorCard)
        val bmiCard: CardView = view.findViewById(R.id.bmiCard)
        val calendarCard: CardView = view.findViewById(R.id.calendarCard)
        val checkboxCard: CardView = view.findViewById(R.id.checkboxCard)

        // Set an OnClickListener for the CardView
        kalkulatorCard.setOnClickListener {
            // Log the click event
            Log.d("HomeFragment", "KalkulatorCard clicked")

            // Create an intent to start KalkulatorActivity
            val intent = Intent(activity, KalkulatorActivity::class.java)

            // Start the activity
            startActivity(intent)
        }

        bmiCard.setOnClickListener {
            // Log the click event
            Log.d("HomeFragment", "BMICard clicked")

            // Create an intent to start BMIActivity
            val intent = Intent(activity, BMIActivity::class.java)

            // Start the activity
            startActivity(intent)
        }

        calendarCard.setOnClickListener {
            // Log the click event
            Log.d("HomeFragment", "CalendarCard clicked")

            // Show the DatePickerDialog
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(requireContext(), { _, selectedYear, selectedMonth, selectedDay ->
                val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
                Snackbar.make(view, "Selected date: $selectedDate", Snackbar.LENGTH_LONG).show()
            }, year, month, day)

            datePickerDialog.show()
        }

        checkboxCard.setOnClickListener {
            // Log the click event
            Log.d("HomeFragment", "CheckboxCard clicked")

            // Create an intent to start CheckboxActivity
            val intent = Intent(activity, CheckboxActivity::class.java)

            // Start the activity
            startActivity(intent)
        }

        return view
    }
}
