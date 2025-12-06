package com.id.makanku.NavComponen.Home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.id.makanku.R

class UmkmAdapter(
    private val list: List<UmkmModel>
) : RecyclerView.Adapter<UmkmAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgFood: ImageView = view.findViewById(R.id.imgFood)
        val tvDiscount: TextView = view.findViewById(R.id.tvDiscount)
        val tvDistance: TextView = view.findViewById(R.id.tvDistance)
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvLocation: TextView = view.findViewById(R.id.tvLocation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_umkm, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.imgFood.setImageResource(item.imageRes)
        holder.tvDiscount.text = "${item.discount}%"
        holder.tvDistance.text = "${item.distance} • ${item.time}"
        holder.tvName.text = item.name
        holder.tvLocation.text = item.location
    }

    override fun getItemCount(): Int = list.size
}
