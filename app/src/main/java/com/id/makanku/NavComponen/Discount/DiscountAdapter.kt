package com.id.makanku.NavComponen.Discount

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.id.makanku.R
import com.id.makanku.model.DiscountItem

class DiscountAdapter(
    private val items: List<DiscountItem>
) : RecyclerView.Adapter<DiscountAdapter.VH>() {

    inner class VH(view: View) : RecyclerView.ViewHolder(view) {
        val imgFood: ImageView = view.findViewById(R.id.imgFood)
        val tvBadge: TextView = view.findViewById(R.id.tvBadge)
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvDesc: TextView = view.findViewById(R.id.tvDesc)
        val tvPrice: TextView = view.findViewById(R.id.tvPrice)
        val btnMau: ImageView = view.findViewById(R.id.btnMau)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_discount, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]

        holder.imgFood.setImageResource(item.imageRes)
        holder.tvBadge.text = "${item.discountPercent}%"
        holder.tvName.text = item.name
        holder.tvDesc.text = item.desc
        holder.tvPrice.text = item.price

        // Klik dinonaktifkan dulu biar tidak error
        holder.itemView.setOnClickListener {}
        holder.btnMau.setOnClickListener {}
    }

    override fun getItemCount(): Int = items.size
}
