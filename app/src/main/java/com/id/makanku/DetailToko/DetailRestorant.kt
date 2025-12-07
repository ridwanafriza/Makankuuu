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
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.card.MaterialCardView
import com.id.makanku.R

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

        // ==== AMBIL VIEW XML ====
        val imgProfile = findViewById<ImageView>(R.id.imgProfile)
        val txtName = findViewById<TextView>(R.id.textView6)
        val txtRating = findViewById<TextView>(R.id.textRating)
        val txtInfo = findViewById<TextView>(R.id.textView7)
        val rvMenu = findViewById<RecyclerView>(R.id.rvMenu)

        // >>>>> INI YANG KAMU MAU <<<<<
        val cardDelivery = findViewById<MaterialCardView>(R.id.cardDetail)

        // ==== BOTTOMSHEET ====
        val bottomSheetView = layoutInflater.inflate(R.layout.delevery_pickup, null)
        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(bottomSheetView)

        // ==== JIKA KLIK CARD DELIVERY, BUKA BOTTOMSHEET ====
        cardDelivery.setOnClickListener {
            bottomSheetDialog.show()
        }

        // ==== DATA INTENT ====
        val restaurantName = intent.getStringExtra("nama") ?: "-"
        val restaurantRating = intent.getStringExtra("rating") ?: "-"
        val restaurantInfo = intent.getStringExtra("info") ?: "-"
        val restaurantImage = intent.getIntExtra("imageRes", 0)

        // ==== SET TEXT ====
        txtName.text = restaurantName
        txtRating.text = restaurantRating
        txtInfo.text = restaurantInfo

        if (restaurantImage != 0) {
            imgProfile.setImageResource(restaurantImage)
        }

        // ==== SET MENU ====
        val listMenu = listOf(
            MenuModel("Ayam Geprek Sambal Ijo", "Ayam geprek dengan nasi pulen...", "16.000", R.drawable.geprek_ijo),
            MenuModel("Ayam Bakar Madu", "Ayam bakar dengan madu...", "18.000", R.drawable.ayam_bakar),
            MenuModel("Ayam Geprek Sambal Matah", "Ayam geprek sambal matah...", "14.000", R.drawable.geprek_sambalmatah)
        )

        rvMenu.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvMenu.adapter = MenuAdapter(listMenu)
    }
}
