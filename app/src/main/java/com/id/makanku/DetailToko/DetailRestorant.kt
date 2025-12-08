package com.id.makanku.DetailToko

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.id.makanku.R
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.card.MaterialCardView

class DetailRestorant : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_restorant)

        // inset UI sesuai system bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.statusBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, 0) // Hapus padding bawah
            WindowInsetsCompat.CONSUMED
        }

        // ambil view dari XML
        val imgProfile = findViewById<ImageView>(R.id.imgProfile)
        val txtName = findViewById<TextView>(R.id.textView6)
        val txtRating = findViewById<TextView>(R.id.textRating)
        val txtInfo = findViewById<TextView>(R.id.textView7)
        val rvMenu = findViewById<RecyclerView>(R.id.rvMenu)
        val cardDelivery = findViewById<MaterialCardView>(R.id.cardDetail)

        // --- Bikin foto restoran bulat ---
        imgProfile.clipToOutline = true
        imgProfile.scaleType = ImageView.ScaleType.CENTER_CROP

        // --- Nama toko center ---
        txtName.textAlignment = TextView.TEXT_ALIGNMENT_CENTER

        // ==== BOTTOMSHEET ====
        val bottomSheetView = layoutInflater.inflate(R.layout.delevery_pickup, null)
        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(bottomSheetView)

        // ==== JIKA KLIK CARD DELIVERY, BUKA BOTTOMSHEET ====
        cardDelivery.setOnClickListener {
            bottomSheetDialog.show()
        }

        // ambil data dari intent
        val restaurantName = intent.getStringExtra("nama") ?: "-"
        val restaurantRating = intent.getStringExtra("rating") ?: "-"
        val restaurantInfo = intent.getStringExtra("info") ?: "-"
        val restaurantImage = intent.getIntExtra("imageRes", 0)

        // set data ke view
        txtName.text = restaurantName
        txtRating.text = restaurantRating
        txtInfo.text = restaurantInfo
        if (restaurantImage != 0) imgProfile.setImageResource(restaurantImage)

        // --- Data menu contoh ---
        val listMenu = listOf(
            MenuModel("Ayam Geprek Sambal Ijo", "Ayam geprek dengan nasi pulen dan sambal ijo...", 16000, R.drawable.geprek_ijo, "50%"),
            MenuModel("Ayam Bakar Madu", "Ayam bakar dengan olesan madu dan rempah...", 18000, R.drawable.ayam_bakar),
            MenuModel("Ayam Geprek Sambal Matah", "Ayam geprek dengan nasi pulen dan sambal...", 14000, R.drawable.geprek_sambalmatah, "20%"),
            MenuModel("Pecel Lele", "Lele goreng sambal pecel", 15000, R.drawable.lele)
        )

        // --- Setup RecyclerView grid 2 kolom ---
        rvMenu.layoutManager = GridLayoutManager(this, 2)
        rvMenu.adapter = MenuAdapter(listMenu)
    }
}
