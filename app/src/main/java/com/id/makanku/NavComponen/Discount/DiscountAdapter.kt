package com.id.makanku.NavComponen.Discount

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.example.app.model.DiscountItem
import kotlinx.android.synthetic.main.item_discount.view.*

class DiscountAdapter(private val items: List<DiscountItem>) :
    RecyclerView.Adapter<DiscountAdapter.DiscountViewHolder>() {

    inner class DiscountViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        fun bind(data: DiscountItem) {
            itemView.tvFoodName.text = data.title
            itemView.tvFoodPrice.text = data.price
            itemView.tvDiscountBadge.text = "${data.discountPercent} %"
            itemView.imgFood.setImageResource(data.imageRes)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscountViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_discount, parent, false)
        return DiscountViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: DiscountViewHolder, position: Int) {
        holder.bind(items[position])
    }
}
