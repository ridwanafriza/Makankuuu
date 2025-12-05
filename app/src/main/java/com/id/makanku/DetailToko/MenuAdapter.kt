package com.id.makanku.DetailToko

import android.view.LayoutInflater
import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.id.makanku.DetailToko.MenuModel
import com.id.makanku.R

class MenuAdapter(private val listMenu: List<MenuModel>) :
    RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    inner class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgMenu: ImageView = itemView.findViewById(R.id.imgMenu)
        val txtNama: TextView = itemView.findViewById(R.id.txtNamaMenu)
        val txtDesc: TextView = itemView.findViewById(R.id.txtDeskripsi)
        val txtHarga: TextView = itemView.findViewById(R.id.txtHarga)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_menu, parent, false)
        return MenuViewHolder(view)
    }

    override fun getItemCount(): Int = listMenu.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = listMenu[position]
        holder.imgMenu.setImageResource(item.imageRes)
        holder.txtNama.text = item.nama
        holder.txtDesc.text = item.deskripsi
        holder.txtHarga.text = item.hargaAsli

        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, FoodDetailActivity::class.java)

            intent.putExtra("nama", item.nama)
            intent.putExtra("deskripsi", item.deskripsi)
            intent.putExtra("harga", item.harga)
            intent.putExtra("gambar", item.imageRes)

            context.startActivity(intent)
        }
    }

}