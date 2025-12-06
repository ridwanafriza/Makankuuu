package com.id.makanku.SearchRestorant

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.id.makanku.R
import android.content.Intent
import com.id.makanku.DetailToko.DetailRestorant

class SearchRestorant : AppCompatActivity() {
    private lateinit var rvRestaurant: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_search_restorant)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        rvRestaurant = findViewById(R.id.rvRestaurant)
        rvRestaurant.layoutManager = LinearLayoutManager(this)

        val restaurantList = listOf(
            RestaurantModel(
                nama = "Dapur Mbok Rini",
                rating = "4.8 (100+ ratings)",
                info = "700m • 15rb - 23rb",
                imageRes = R.drawable.geprek_sambalmatah,
                diskon = "50%"
            ),
            RestaurantModel(
                nama = "Ayam Geprek Iwan",
                rating = "4.8 (90+ ratings)",
                info = "400m • 15rb - 25rb",
                imageRes = R.drawable.ayam_bakar,
                diskon = "30%"
            ),
            RestaurantModel(
                nama = "Geprek Gassin",
                rating = "4.7 (70+ ratings)",
                info = "400m • 15rb - 25rb",
                imageRes = R.drawable.geprek_sambalmatah,
                diskon = "50%"
            )

        )

        rvRestaurant.adapter = RestaurantAdapter(restaurantList, object : OnRestaurantClickListener {
            override fun onItemClick(item: RestaurantModel) {

                // buka halaman DetailRestorant + kirim data
                val intent = Intent(this@SearchRestorant, DetailRestorant::class.java)
                intent.putExtra("nama", item.nama)
                intent.putExtra("gambar", item.imageRes)
                startActivity(intent)
            }
        })
    }
}