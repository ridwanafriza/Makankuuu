package com.id.makanku.DetailPesanan

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.id.makanku.R

class QrisPaymentActivity : AppCompatActivity() {
    private var totalHarga: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_qris_payment)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainQris)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        totalHarga = intent.getIntExtra("TOTAL_HARGA", 0)

        val txtTotal = findViewById<TextView>(R.id.txtTotalQris)
        val btnBayar = findViewById<Button>(R.id.btnBayarQris)

        txtTotal.text = "Total: Rp $totalHarga"

        btnBayar.setOnClickListener {
            // TODO: Implementasi pembayaran QRIS (scan atau API gateway)
            Toast.makeText(this, "Pembayaran QRIS berhasil\nTotal: Rp $totalHarga", Toast.LENGTH_LONG).show()
            finish() // kembali ke DetailPesanan
        }
    }
}