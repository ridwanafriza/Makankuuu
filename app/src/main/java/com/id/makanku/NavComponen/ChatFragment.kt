package com.id.makanku.NavComponen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.id.makanku.R
import androidx.navigation.fragment.findNavController


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ChatFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class ChatFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ChatAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rvChat)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // ---- DATA DUMMY BIAR ITEM MUNCUL ----
        val chatList = listOf(
            ChatModel("Driver", "Dimana mba?", 1),
            ChatModel("Nadya", "Oke ka", 0),
            ChatModel("Driver", "Saya otw ya", 3)
        )

        adapter = ChatAdapter(chatList) { chatItem ->
            val action = ChatFragmentDirections
                .actionChatFragmentToChatDetailFragment(chatItem.name)

            findNavController().navigate(action)


        }

        recyclerView.adapter = adapter
    }
}