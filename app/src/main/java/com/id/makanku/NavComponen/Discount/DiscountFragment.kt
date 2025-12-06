package com.id.makanku.NavComponen.Discount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.app.R
import com.example.app.adapter.DiscountAdapter
import com.example.app.model.DiscountItem
import kotlinx.android.synthetic.main.fragment_discount.*

class DiscountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_discount, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val items = listOf(
            DiscountItem("Ayam Geprek Sambal Ijo", "16.000", R.drawable.sample_food, 50),
            DiscountItem("Ayam Geprek Sambal Ijo", "16.000", R.drawable.sample_food, 50),
            DiscountItem("Ayam Geprek Sambal Ijo", "16.000", R.drawable.sample_food, 50),
            DiscountItem("Ayam Geprek Sambal Ijo", "16.000", R.drawable.sample_food, 50)
        )

        rvDiscount.layoutManager = GridLayoutManager(requireContext(), 2)
        rvDiscount.adapter = DiscountAdapter(items)
    }
}

