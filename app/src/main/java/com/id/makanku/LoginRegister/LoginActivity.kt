package com.id.makanku.LoginRegister

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.id.makanku.MainActivity
import com.id.makanku.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        // Untuk padding otomatis agar tidak ketiban status bar / navigation bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txtRegister: TextView = findViewById(R.id.textView4)

        txtRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        // Inisialisasi komponen
        val editTextEmail: EditText = findViewById(R.id.editTextTextEmailAddress)
        val editTextPassword: EditText = findViewById(R.id.editTextTextPassword)
        val buttonLogin: Button = findViewById(R.id.button)

        val btnMahasiswa: TextView = findViewById(R.id.btnMahasiswa)
        val btnUmkm: TextView = findViewById(R.id.btnUmkm)

        btnMahasiswa.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("role", "mahasiswa")
            startActivity(intent)
        }
        btnUmkm.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("role", "umkm")
            startActivity(intent)
        }

        // Aksi login
        buttonLogin.setOnClickListener {
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            // Validasi sederhana
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Email dan Password harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Pindah halaman
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(KEY_USERNAME, email)
            startActivity(intent)

            Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        const val KEY_USERNAME = "username"
    }
}