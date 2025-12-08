package com.id.makanku.NavComponen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.id.makanku.R
class ChatDetailAdapter(
    private val chatList: List<ChatDetailModel>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TYPE_RIGHT = 1
    private val TYPE_LEFT = 2

    override fun getItemViewType(position: Int): Int {
        return if (chatList[position].isMe) TYPE_RIGHT else TYPE_LEFT
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return if (viewType == TYPE_RIGHT) {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_chat_right, parent, false)
            RightHolder(view)
        } else {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_chat_left, parent, false)
            LeftHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = chatList[position]

        if (holder is RightHolder) {
            holder.text.text = item.message
        } else if (holder is LeftHolder) {
            holder.text.text = item.message
        }
    }

    override fun getItemCount(): Int = chatList.size

    class RightHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text = itemView.findViewById<TextView>(R.id.tvMessageRight)
    }

    class LeftHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text = itemView.findViewById<TextView>(R.id.tvMessageLeft)
    }
}