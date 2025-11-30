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

        // Padding agar tidak ketiban status bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Tombol menuju Register
        val txtRegister: TextView = findViewById(R.id.textView4)
        txtRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        // Inisialisasi komponen input login
        val editTextEmail: EditText = findViewById(R.id.editTextTextEmailAddress)
        val editTextPassword: EditText = findViewById(R.id.editTextTextPassword)
        val buttonLogin: Button = findViewById(R.id.button)

        // Tombol role Mahasiswa & UMKM
        val btnMahasiswa: TextView = findViewById(R.id.btnMahasiswa)
        val btnUmkm: TextView = findViewById(R.id.btnUmkm)

        // Default selected → Mahasiswa (opsional)
        btnMahasiswa.setBackgroundResource(R.drawable.bg_segment_selected)
        btnMahasiswa.setTextColor(resources.getColor(android.R.color.black))
        btnUmkm.setTextColor(resources.getColor(android.R.color.darker_gray))
        btnUmkm.setBackgroundResource(android.R.color.transparent)

        // Klik Mahasiswa → tombol hijau pindah
        btnMahasiswa.setOnClickListener {
            btnMahasiswa.setBackgroundResource(R.drawable.bg_segment_selected)
            btnMahasiswa.setTextColor(resources.getColor(android.R.color.black))

            btnUmkm.setBackgroundResource(android.R.color.transparent)
            btnUmkm.setTextColor(resources.getColor(android.R.color.darker_gray))
        }

        // Klik UMKM → tombol hijau pindah
        btnUmkm.setOnClickListener {
            btnUmkm.setBackgroundResource(R.drawable.bg_segment_selected)
            btnUmkm.setTextColor(resources.getColor(android.R.color.black))

            btnMahasiswa.setBackgroundResource(android.R.color.transparent)
            btnMahasiswa.setTextColor(resources.getColor(android.R.color.darker_gray))
        }

        // Aksi Login
        buttonLogin.setOnClickListener {
            val email = editTextEmail.text.toString().trim()
            val password = editTextPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Email dan Password harus diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Masuk ke halaman MainActivity
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
