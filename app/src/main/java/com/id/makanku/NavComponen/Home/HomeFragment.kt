package com.id.makanku.NavComponen.Home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.id.makanku.R
import com.id.makanku.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val listUmkm = listOf(
            UmkmModel(1, "warung sambal kuy", "jl. serayu timur v", "1.5 km", "5–10 min", 50, R.drawable.ayam_bakar),
            UmkmModel(2, "ayam geprek maknyus", "jl. anggrek 4", "2.1 km", "10–15 min", 30, R.drawable.ayam_bakar)
        )

        binding.rvPopular.layoutManager = LinearLayoutManager(requireContext())
        binding.rvPopular.adapter = UmkmAdapter(listUmkm)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
