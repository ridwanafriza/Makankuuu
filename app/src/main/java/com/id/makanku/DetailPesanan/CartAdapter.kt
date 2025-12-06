package com.id.makanku.DetailPesanan

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.id.makanku.R

class CartAdapter(
    private val listCart: MutableList<CartItem>,
    private val onQtyChanged: () -> Unit
) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgMenu = itemView.findViewById<ImageView>(R.id.imgMenuCart)
        val txtNama = itemView.findViewById<TextView>(R.id.txtNamaMenuCart)
        val txtHarga = itemView.findViewById<TextView>(R.id.txtHargaCart)
        val txtQty = itemView.findViewById<TextView>(R.id.txtQty)
        val btnPlus = itemView.findViewById<TextView>(R.id.btnPlus)
        val btnMinus = itemView.findViewById<TextView>(R.id.btnMinus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_cart, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listCart[position]

        holder.imgMenu.setImageResource(item.gambar)
        holder.txtNama.text = item.nama
        holder.txtHarga.text = "RP ${item.harga * item.jumlah}"
        holder.txtQty.text = item.jumlah.toString()

        holder.btnPlus.setOnClickListener {
            item.jumlah++
            notifyItemChanged(position)
            onQtyChanged()
        }

        holder.btnMinus.setOnClickListener {
            if (item.jumlah > 1) {
                item.jumlah--
                notifyItemChanged(position)
                onQtyChanged()
            }
        }
    }

    override fun getItemCount(): Int = listCart.size
}