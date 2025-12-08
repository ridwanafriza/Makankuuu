package com.id.makanku.DetailPesanan

import android.content.Intent
import android.os.Bundle
import android.widget.*
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

        // Ambil data dari FoodDetailActivity
        val nama = intent.getStringExtra("nama")
        val harga = intent.getIntExtra("harga", 0)
        val gambar = intent.getIntExtra("gambar", 0)

        // Masukkan ke keranjang kalau datanya valid
        if (nama != null && harga > 0) {
            listCart.add(CartItem(nama, harga, 1, gambar))
        }

        cartAdapter = CartAdapter(listCart) {
            hitungTotal()
        }

        rvCart.adapter = cartAdapter
        hitungTotal()

        val rbGroup = findViewById<RadioGroup>(R.id.rbPaymentGroup)
        val rbCash = findViewById<RadioButton>(R.id.rbCash)
        val rbQRIS = findViewById<RadioButton>(R.id.rbQRIS)
        val btnPayment = findViewById<Button>(R.id.btnPayment)

        btnPayment.setOnClickListener {
            val selectedPaymentId = rbGroup.checkedRadioButtonId

            if (selectedPaymentId == -1) {
                Toast.makeText(this, "Pilih metode pembayaran terlebih dahulu", Toast.LENGTH_SHORT).show()
            } else {
                val paymentMethod = when (selectedPaymentId) {
                    R.id.rbCash -> "Cash"
                    R.id.rbQRIS -> "QRIS"
                    else -> ""
                }

                val totalHarga = listCart.sumOf { it.harga * it.jumlah }

                when (paymentMethod) {
                    "Cash" -> {
                        // Contoh: tampilkan konfirmasi bayar cash
                        Toast.makeText(this, "Bayar secara Cash\nTotal: Rp $totalHarga", Toast.LENGTH_LONG).show()
                        // TODO: Lanjutkan logika cash (misal update database, selesai transaksi)
                    }
                    "QRIS" -> {
                        // Contoh: pindah ke halaman QRIS
                        val intent = Intent(this, QrisPaymentActivity::class.java)
                        intent.putExtra("TOTAL_HARGA", totalHarga)
                        startActivity(intent)
                    }
                }
            }
        }
    }

    private fun hitungTotal() {
        var total = 0
        for (item in listCart) {
            total += item.harga * item.jumlah
        }

        val txtTotal = findViewById<TextView>(R.id.txtTotal)

        txtTotal.text = "Rp $total"
    }
}
