package com.id.makanku.NavComponen.Home


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.id.makanku.NavComponen.Home.HistoryModel
import com.id.makanku.databinding.ItemHistoryBinding

class HistoryAdapter(private val list: List<HistoryModel>) :
    RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemHistoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemHistoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.binding.imgHistory.setImageResource(item.image)
        holder.binding.txtTitle.text = item.title
        holder.binding.txtDate.text = item.date
        holder.binding.txtPrice.text = item.price
    }

    override fun getItemCount(): Int = list.size
}
