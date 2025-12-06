package com.id.makanku.SearchRestorant

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.id.makanku.R

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
                imageRes = R.drawable.ayambakar,
                diskon = "30%"
            ),
            RestaurantModel(
                nama = "Geprek Gassin",
                rating = "4.7 (70+ ratings)",
                info = "400m • 15rb - 25rb",
                imageRes = R.drawable.geprek_sambalmatah,
                diskon = "50%"
            ),

            // ---------------- 7 MENU TAMBAHAN ------------------

            RestaurantModel(
                nama = "Sate Pak Kumis",
                rating = "4.9 (200+ ratings)",
                info = "1 km • 20rb - 30rb",
                imageRes = R.drawable.sate,
                diskon = "40%"
            ),
            RestaurantModel(
                nama = "Bakso Mang Udin",
                rating = "4.6 (150+ ratings)",
                info = "600m • 10rb - 20rb",
                imageRes = R.drawable.bakso,
                diskon = "20%"
            ),
            RestaurantModel(
                nama = "Warung Nasi Bu Rara",
                rating = "4.8 (300+ ratings)",
                info = "1.2 km • 12rb - 18rb",
                imageRes = R.drawable.warungnasi,
                diskon = "35%"
            ),
            RestaurantModel(
                nama = "Ayam Bakar Marem",
                rating = "4.7 (120+ ratings)",
                info = "900m • 18rb - 25rb",
                imageRes = R.drawable.ayambakar,
                diskon = "25%"
            ),
            RestaurantModel(
                nama = "Mie Ayam Pedas Joss",
                rating = "4.5 (80+ ratings)",
                info = "500m • 13rb - 20rb",
                imageRes = R.drawable.mie_ayam,
                diskon = "15%"
            ),
            RestaurantModel(
                nama = "Pecel Lele Mbok Sri",
                rating = "4.6 (140+ ratings)",
                info = "650m • 12rb - 22rb",
                imageRes = R.drawable.lele,
                diskon = "30%"
            ),
            RestaurantModel(
                nama = "Tahu Crispy Mas Bro",
                rating = "4.7 (110+ ratings)",
                info = "700m • 8rb - 15rb",
                imageRes = R.drawable.tahu_krispi,
                diskon = "10%"
            )
        )

        rvRestaurant.adapter = RestaurantAdapter(restaurantList)
    }
}
