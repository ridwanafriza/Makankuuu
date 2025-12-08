package com.id.makanku.NavComponen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.id.makanku.R

class ChatAdapter(
    private val list: List<ChatModel>,
    private val onItemClick: (ChatModel) -> Unit
) : RecyclerView.Adapter<ChatAdapter.ChatHolder>() {

    class ChatHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tvName)
        val message: TextView = itemView.findViewById(R.id.tvMessage)
        val badge: TextView = itemView.findViewById(R.id.tvBadge)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chat, parent, false)
        return ChatHolder(view)
    }

    override fun onBindViewHolder(holder: ChatHolder, position: Int) {
        val item = list[position]

        holder.name.text = item.name
        holder.message.text = item.lastMessage

        // badge notif
        holder.badge.text = item.badge.toString()
        holder.badge.visibility = if (item.badge > 0) View.VISIBLE else View.GONE

        // --- klik item ---
        holder.itemView.setOnClickListener {
            onItemClick(item)
        }
    }

    override fun getItemCount(): Int = list.size
}
