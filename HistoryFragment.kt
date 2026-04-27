package com.utama.aplikasikendarin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.utama.aplikasikendarin.databinding.FragmentHistoryBinding

class HistoryFragment : Fragment() {

    private var _binding: FragmentHistoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHistoryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Inisialisasi Data (Kosongkan dulu untuk ngetes Empty State)
        val listHistory = mutableListOf<String>() // Ganti String dengan Model Transaksi kamu nanti

        // 2. Setup RecyclerView
        binding.rvHistory.layoutManager = LinearLayoutManager(requireContext())

        // 3. Logika Tampilan: Jika data kosong, tampilkan layoutEmptyState
        if (listHistory.isEmpty()) {
            binding.layoutEmptyState.visibility = View.VISIBLE
            binding.rvHistory.visibility = View.GONE
        } else {
            binding.layoutEmptyState.visibility = View.GONE
            binding.rvHistory.visibility = View.VISIBLE

            // Pasang adapter di sini jika sudah ada datanya
            // binding.rvHistory.adapter = HistoryAdapter(listHistory)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
