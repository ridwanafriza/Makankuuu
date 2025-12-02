package com.id.makanku.LoginRegister

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.id.makanku.R

class RegisterActivity : AppCompatActivity() {

    private var isPasswordVisible = false
    private var isConfirmPasswordVisible = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        // Menghindari layout ketiban status bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Tombol Register & Login
        val btnRegister = findViewById<Button>(R.id.button)
        val txtLogin = findViewById<TextView>(R.id.textView5)

        // SEGMENT Mahasiswa & UMKM
        val btnMahasiswa = findViewById<TextView>(R.id.btnMahasiswa)
        val btnUmkm = findViewById<TextView>(R.id.btnUmkm)

        // Default: Mahasiswa aktif
        btnMahasiswa.setBackgroundResource(R.drawable.bg_segment_selected)
        btnMahasiswa.setTextColor(resources.getColor(android.R.color.black))
        btnUmkm.setBackgroundResource(android.R.color.transparent)
        btnUmkm.setTextColor(resources.getColor(android.R.color.darker_gray))

        // Klik Mahasiswa → aktif
        btnMahasiswa.setOnClickListener {
            btnMahasiswa.setBackgroundResource(R.drawable.bg_segment_selected)
            btnMahasiswa.setTextColor(resources.getColor(android.R.color.black))

            btnUmkm.setBackgroundResource(android.R.color.transparent)
            btnUmkm.setTextColor(resources.getColor(android.R.color.darker_gray))
        }

        // Klik UMKM → aktif
        btnUmkm.setOnClickListener {
            btnUmkm.setBackgroundResource(R.drawable.bg_segment_selected)
            btnUmkm.setTextColor(resources.getColor(android.R.color.black))

            btnMahasiswa.setBackgroundResource(android.R.color.transparent)
            btnMahasiswa.setTextColor(resources.getColor(android.R.color.darker_gray))
        }

        val edtPassword = findViewById<EditText>(R.id.editTextTextPassword)
        val edtKonfirmasi = findViewById<EditText>(R.id.konfirmasipassword)
        val eyePassword = findViewById<ImageView>(R.id.eyePassword)
        val eyeConfirm = findViewById<ImageView>(R.id.eyeConfirmPassword)

        eyePassword.setOnClickListener {
            isPasswordVisible = togglePassword(edtPassword, eyePassword, isPasswordVisible)
        }

        eyeConfirm.setOnClickListener {
            isConfirmPasswordVisible = togglePassword(edtKonfirmasi, eyeConfirm, isConfirmPasswordVisible)
        }


        // Tombol Register → pindah ke Login
        btnRegister.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }

        // Text "Login" → pindah ke Login
        txtLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun togglePassword(edit: EditText, eye: ImageView, isVisible: Boolean): Boolean {
        val newVisible = !isVisible

        if (newVisible) {
            edit.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            eye.setImageResource(R.drawable.baseline_visibility_24)
        } else {
            edit.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            eye.setImageResource(R.drawable.baseline_visibility_off_24)
        }

        edit.setSelection(edit.text.length) // supaya kursor tidak pindah
        return newVisible
    }
}
