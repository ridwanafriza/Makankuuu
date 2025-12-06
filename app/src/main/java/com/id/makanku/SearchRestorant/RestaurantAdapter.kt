package com.id.makanku.SearchRestorant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.id.makanku.R

interface OnRestaurantClickListener {
    fun onItemClick(item: RestaurantModel)
}

class RestaurantAdapter(private val list: List<RestaurantModel>, private val listener: OnRestaurantClickListener ) :
    RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.imgFood)
        val name: TextView = view.findViewById(R.id.txtName)
        val rating: TextView = view.findViewById(R.id.txtRating)
        val info: TextView = view.findViewById(R.id.txtInfo)
        val discount: TextView = view.findViewById(R.id.txtDiscount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_restaurant, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.img.setImageResource(item.imageRes)
        holder.name.text = item.nama
        holder.rating.text = item.rating
        holder.info.text = item.info

        if (item.diskon != null) {
            holder.discount.text = item.diskon
            holder.discount.visibility = View.VISIBLE
        } else {
            holder.discount.visibility = View.GONE
        }
        holder.itemView.setOnClickListener {
            listener.onItemClick(item)
        }
    }
    override fun getItemCount(): Int = list.size
}
