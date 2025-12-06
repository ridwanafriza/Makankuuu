package com.id.makanku.DetailToko

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.id.makanku.R

class DetailRestorant : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_restorant)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // ================================
        // AMBIL DATA DARI INTENT
        // ================================
        val restaurantName = intent.getStringExtra("nama")
        val restaurantRating = intent.getStringExtra("rating")
        val restaurantInfo = intent.getStringExtra("info")
        val restaurantDiskon = intent.getStringExtra("diskon")
        val restaurantImage = intent.getIntExtra("imageRes", 0)

        // ================================
        // FIND VIEW SESUAI XML
        // ================================
        val txtNama = findViewById<TextView>(R.id.textView6)
        val txtDeskripsi = findViewById<TextView>(R.id.textView7)
        val txtRating = findViewById<TextView>(R.id.textRating)
        val txtInfo = findViewById<TextView>(R.id.textInfo)
        val imgProfile = findViewById<ImageView>(R.id.imgProfile)   // ⭐ DITAMBAHKAN

        // ================================
        // SET DATA KE UI
        // ================================
        txtNama.text = restaurantName ?: "Nama restoran"

        // 🔧 Perbaikan BESAR:
        // textView7 = deskripsi → seharusnya kamu punya DESKRIPSI sendiri
        // tapi karena datanya belum ada, sementara ditampilkan dummy
        txtDeskripsi.text = "Aneka ayam geprek, goreng, bakar, dll."  // ⭐ FIX

        txtRating.text = restaurantRating ?: "0.0"
        txtInfo.text = restaurantInfo ?: "Info restoran"
        if (restaurantImage != 0) imgProfile.setImageResource(restaurantImage)  // ⭐ DITAMBAHKAN


        // ================================
        // DATA MENU
        // ================================
        val listMenu = listOf(
            MenuModel(
                "Ayam Geprek Sambal Ijo",
                "Ayam geprek dengan nasi pulen dan sambal ijo...",
                "16.000",
                R.drawable.geprek_ijo
            ),
            MenuModel(
                "Ayam Bakar Madu",
                "Ayam bakar dengan olesan madu dan rempah...",
                "18.000",
                R.drawable.ayam_bakar
            ),
            MenuModel(
                "Ayam Geprek Sambal Matah",
                "Ayam geprek dengan nasi pulen dan sambal matah...",
                "14.000",
                R.drawable.geprek_sambalmatah
            )
        )

        val rvMenu = findViewById<RecyclerView>(R.id.rvMenu)
        rvMenu.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvMenu.adapter = MenuAdapter(listMenu)
    }
}
