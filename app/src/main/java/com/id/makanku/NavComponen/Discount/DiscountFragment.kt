package com.id.makanku.NavComponen.Discount

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.id.makanku.NavComponen.Discount.DiscountAdapter
import com.id.makanku.databinding.FragmentDiscountBinding
import com.id.makanku.model.DiscountItem
import com.id.makanku.R

class DiscountFragment : Fragment() {

    private var _binding: FragmentDiscountBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDiscountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val items = listOf(
            DiscountItem("Ayam Geprek Sambal Ijo", "16.000", R.drawable.geprek_sambalmatah, 50, "Pedas mantap"),
            DiscountItem("Ayam Geprek Keju", "18.000", R.drawable.geprek_ijo, 40, "Gurih"),
            DiscountItem("Ayam Geprek Matah", "17.000", R.drawable.sate, 35, "Segar"),
            DiscountItem("Ayam Geprek Original", "15.000", R.drawable.ayam_bakar, 20, "Crispy")
        )

        binding.rvDiscount.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvDiscount.adapter = DiscountAdapter(items)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
