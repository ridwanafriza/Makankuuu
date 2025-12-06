package com.id.makanku.DetailToko

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.TextView
import com.id.makanku.DetailToko.MenuAdapter
import com.id.makanku.DetailToko.MenuModel
import com.id.makanku.R

class DetailRestorant : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_restorant)

        // inset sesuai system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ambil data dari Intent
        val restaurantName = intent.getStringExtra("nama")
        val restaurantRating = intent.getStringExtra("rating")
        val restaurantInfo = intent.getStringExtra("info")
        val restaurantDiscount = intent.getStringExtra("diskon")

        // Cocokkan dengan ID di XML
        val txtNama = findViewById<TextView>(R.id.textView6)
        val txtDeskripsi = findViewById<TextView>(R.id.textView7)
        val txtRating = findViewById<TextView>(R.id.textRating)
        val txtInfo = findViewById<TextView>(R.id.textInfo)

        // Set data ke tampilan
        txtNama.text = restaurantName ?: "Nama restoran"
        txtDeskripsi.text = restaurantInfo ?: "Deskripsi restoran"
        txtRating.text = restaurantRating ?: "0.0"
        txtInfo.text = restaurantInfo ?: "Info restoran"

        // Data menu contoh
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

        // RecyclerView menu
        val rvMenu = findViewById<RecyclerView>(R.id.rvMenu)
        rvMenu.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvMenu.adapter = MenuAdapter(listMenu)
    }
}
