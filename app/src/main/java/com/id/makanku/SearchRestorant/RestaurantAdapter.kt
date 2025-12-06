package com.id.makanku.SearchRestorant

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.id.makanku.DetailToko.DetailRestorant
import com.id.makanku.R

class RestaurantAdapter(private val list: List<RestaurantModel>) :
    RecyclerView.Adapter<RestaurantAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val img: ImageView = view.findViewById(R.id.imgFood)
        val name: TextView = view.findViewById(R.id.txtName)
        val rating: TextView = view.findViewById(R.id.txtRating)
        val info: TextView = view.findViewById(R.id.txtInfo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_restaurant, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        // set data
        holder.img.setImageResource(item.imageRes)
        holder.name.text = item.nama
        holder.rating.text = item.rating
        holder.info.text = item.info

        // klik ke DetailRestorant
        holder.itemView.setOnClickListener { v ->
            val context = v.context
            val intent = Intent(context, DetailRestorant::class.java)
            intent.putExtra("nama", item.nama)
            intent.putExtra("rating", item.rating)
            intent.putExtra("info", item.info)
            intent.putExtra("imageRes", item.imageRes) // penting: key sesuai DetailRestorant
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = list.size
}
