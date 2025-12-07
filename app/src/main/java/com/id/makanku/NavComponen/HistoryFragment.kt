package com.id.makanku.NavComponen.Home





import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.id.makanku.R
import com.id.makanku.NavComponen.Home.HistoryAdapter
import com.id.makanku.NavComponen.Home.HistoryModel
import com.id.makanku.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {

    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerHistory.layoutManager = LinearLayoutManager(requireContext())

        val historyList = listOf(
            HistoryModel(
                R.drawable.geprek_sambalmatah,
                "2 Ayam geprek",
                "Sel, 6 Jun 2025",
                "Rp 34.000"
            ),
            HistoryModel(
                R.drawable.lele,
                "Pecel Lele",
                "Sel, 11 Jun 2025",
                "Rp 15.000"
            ),
            HistoryModel(
                R.drawable.geprek_sambalmatah,
                "3 Ayam Geprek",
                "Rab, 17 Jun 2025",
                "Rp 36.000"
            ),
            HistoryModel(
                R.drawable.ayam_bakar,
                "Ayam Bakar",
                "Ming, 21 Jun 2025",
                "Rp 20.000"
            )
        )

        val adapter = HistoryAdapter(historyList)
        binding.recyclerHistory.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
