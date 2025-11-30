package com.id.makanku.LoginRegister

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.id.makanku.R

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        // Hindari ketiban status bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Tombol Register & Login
        val btnRegister = findViewById<Button>(R.id.button)
        val txtLogin = findViewById<TextView>(R.id.textView5)

        // SEGMENT tombol Mahasiswa & UMKM
        val btnMahasiswa = findViewById<TextView>(R.id.btnMahasiswa)
        val btnUmkm = findViewById<TextView>(R.id.btnUmkm)

        // Default Mahasiswa aktif
        btnMahasiswa.setBackgroundResource(R.drawable.bg_segment_selected)
        btnMahasiswa.setTextColor(resources.getColor(android.R.color.black))
        btnUmkm.setBackgroundResource(android.R.color.transparent)
        btnUmkm.setTextColor(resources.getColor(android.R.color.darker_gray))

        // Klik Mahasiswa → jadi aktif
        btnMahasiswa.setOnClickListener {
            btnMahasiswa.setBackgroundResource(R.drawable.bg_segment_selected)
            btnMahasiswa.setTextColor(resources.getColor(android.R.color.black))

            btnUmkm.setBackgroundResource(android.R.color.transparent)
            btnUmkm.setTextColor(resources.getColor(android.R.color.darker_gray))
        }

        // Klik UMKM → jadi aktif
        btnUmkm.setOnClickListener {
            btnUmkm.setBackgroundResource(R.drawable.bg_segment_selected)
            btnUmkm.setTextColor(resources.getColor(android.R.color.black))

            btnMahasiswa.setBackgroundResource(android.R.color.transparent)
            btnMahasiswa.setTextColor(resources.getColor(android.R.color.darker_gray))
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
}
