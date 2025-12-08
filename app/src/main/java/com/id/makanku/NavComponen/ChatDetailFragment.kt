package com.id.makanku.NavComponen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.id.makanku.R

class ChatDetailFragment : Fragment() {

    private lateinit var rvChat: RecyclerView
    private lateinit var etMessage: EditText
    private lateinit var btnSend: ImageView
    private lateinit var adapter: ChatDetailAdapter

    private val chatList = ArrayList<ChatDetailModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chat_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Hide bottom nav
        val bottomNav = requireActivity().findViewById<View>(R.id.bottomNavigation)
        bottomNav.visibility = View.GONE

        rvChat = view.findViewById(R.id.rvChatDetail)
        etMessage = view.findViewById(R.id.etMessage)
        btnSend = view.findViewById(R.id.btnSend)

        adapter = ChatDetailAdapter(chatList)
        rvChat.layoutManager = LinearLayoutManager(requireContext())
        rvChat.adapter = adapter

        // ==== SEND BUTTON ====
        btnSend.setOnClickListener {
            val message = etMessage.text.toString().trim()

            if (message.isNotEmpty()) {

                // Tambah pesan saya (bubble kanan)
                val myChat = ChatDetailModel(message, true)
                chatList.add(myChat)
                adapter.notifyItemInserted(chatList.size - 1)

                rvChat.scrollToPosition(chatList.size - 1)
                etMessage.text.clear()

                // Optional: auto balasan dummy (bubble kiri)
                rvChat.postDelayed({
                    val reply = ChatDetailModel("Pesan diterima!", false)
                    chatList.add(reply)
                    adapter.notifyItemInserted(chatList.size - 1)
                    rvChat.scrollToPosition(chatList.size - 1)
                }, 600)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        val bottomNav = requireActivity().findViewById<View>(R.id.bottomNavigation)
        bottomNav.visibility = View.VISIBLE
    }
}
