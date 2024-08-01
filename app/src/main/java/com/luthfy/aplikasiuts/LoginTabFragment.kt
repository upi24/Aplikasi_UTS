package com.luthfy.aplikasiuts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class LoginTabFragment : Fragment() {

    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login_tab, container, false)

        // Menghubungkan elemen-elemen dengan ID dari XML
        emailEditText = view.findViewById(R.id.login_email)
        passwordEditText = view.findViewById(R.id.login_password)
        loginButton = view.findViewById(R.id.login_button)

        // Menambahkan onClickListener pada tombol login
        loginButton.setOnClickListener {
            handleLogin()
        }

        return view
    }

    private fun handleLogin() {
        val email = emailEditText.text.toString()
        val password = passwordEditText.text.toString()

        // Cek apakah email dan password tidak kosong
        if (email.isNotBlank() && password.isNotBlank()) {
            // Untuk contoh ini, kita hanya menunjukkan pesan Toast
            // Implementasikan logika login di sini (misalnya validasi, autentikasi)
            Toast.makeText(requireContext(), "Login successful", Toast.LENGTH_SHORT).show()

            // Navigasi ke DashboardActivity setelah login sukses
            (activity as? MainActivity)?.navigateToDashboard()
        } else {
            Toast.makeText(requireContext(), "Email or Password cannot be empty", Toast.LENGTH_SHORT).show()
        }
    }
}