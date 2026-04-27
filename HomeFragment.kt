package com.utama.aplikasikendarin

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.utama.aplikasikendarin.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 1. Menampilkan Nama User
        val username = activity?.intent?.getStringExtra("username")
        if (!username.isNullOrEmpty()) {
            binding.tvWelcomeUser.text = "Halo, $username!"
        }

        // 2. Navigasi Klik Teks "Lihat Semua"
        binding.tvSeeAllBrands.setOnClickListener {
            val intent = Intent(requireContext(), ListKendaraanActivity::class.java)
            startActivity(intent)
        }

        /* CATATAN: Bagian klik CardPromo dan Brand di bawah ini
           dimatikan dulu (comment) supaya aplikasimu BISA JALAN.
           Kamu harus nambahin ID di fragment_home.xml dulu baru bisa dipake lagi.
        */

        /*
        binding.cardPromo.setOnClickListener {
            val intent = Intent(requireContext(), ListKendaraanActivity::class.java)
            intent.putExtra("NAMA_BRAND", "Porsche")
            startActivity(intent)
        }
        */
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
