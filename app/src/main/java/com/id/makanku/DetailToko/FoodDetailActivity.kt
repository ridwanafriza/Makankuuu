package com.id.makanku.DetailToko

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.id.makanku.DetailPesanan.DetailPesanan
import com.id.makanku.R

class FoodDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_food_detail)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ambil data dari intent
        val nama = intent.getStringExtra("nama")
        val deskripsi = intent.getStringExtra("deskripsi")
        val harga = intent.getStringExtra("harga")
        val gambar = intent.getIntExtra("gambar", 0)

        // Sambungkan ke view
        val imgFood = findViewById<ImageView>(R.id.imgFood)
        val txtNama = findViewById<TextView>(R.id.txtNamaMakanan)
        val txtDesk = findViewById<TextView>(R.id.txtDeskripsi)
        val txtHarga = findViewById<TextView>(R.id.txtHarga)
        val btnTambah = findViewById<Button>(R.id.btnTambah)

        // Tampilkan data
        txtNama.text = nama
        txtDesk.text = deskripsi
        txtHarga.text = harga
        if (gambar != 0) {
            imgFood.setImageResource(gambar)
        }

        // ➜ Ketika tombol “Cus Tambahin” ditekan
        btnTambah.setOnClickListener {
            val intent = Intent(this, DetailPesanan::class.java)

            intent.putExtra("nama", nama)
            intent.putExtra("harga", harga)
            intent.putExtra("gambar", gambar)

            startActivity(intent)
        }
    }
}
