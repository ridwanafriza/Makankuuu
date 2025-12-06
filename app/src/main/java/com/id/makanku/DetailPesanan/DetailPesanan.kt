package com.id.makanku.DetailPesanan

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.id.makanku.R

class DetailPesanan : AppCompatActivity() {

    private lateinit var rvCart: RecyclerView
    private lateinit var cartAdapter: CartAdapter
    private val listCart = mutableListOf<CartItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail_pesanan)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        rvCart = findViewById(R.id.rvCart)
        rvCart.layoutManager = LinearLayoutManager(this)

        listCart.add(CartItem("Ayam Geprek", 10000, 1, R.drawable.geprek_ijo))
        listCart.add(CartItem("Ayam Sambal Ijo", 15000, 2, R.drawable.geprek_ijo))

        cartAdapter = CartAdapter(listCart) {
            hitungTotal()
        }
        rvCart.adapter = cartAdapter

        hitungTotal()
    }

    private fun hitungTotal() {
        var total = 0
        for (item in listCart) {
            total += item.harga * item.jumlah
        }

        val txtTotal = findViewById<TextView>(R.id.txtTotal)
        val txtGrandTotal = findViewById<TextView>(R.id.txtGrandTotal)

        txtTotal.text = "Rp $total"
        txtGrandTotal.text = "Rp $total"
    }
}