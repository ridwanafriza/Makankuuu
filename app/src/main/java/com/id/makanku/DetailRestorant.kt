package com.id.makanku

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DetailRestorant : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_restorant)

        // inset UI sesuai system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // data menu
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
                "Ayam geprek dengan nasi pulen dan sambal...",
                "14.000",
                R.drawable.geprek_sambalmatah
            )
        )

        // ambil RecyclerView
        val rvMenu = findViewById<RecyclerView>(R.id.rvMenu)

        // horizontal scroll sesuai CardView 170dp
        rvMenu.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvMenu.adapter = MenuAdapter(listMenu)
    }
}
