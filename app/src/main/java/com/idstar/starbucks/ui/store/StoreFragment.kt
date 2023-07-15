package com.idstar.starbucks.ui.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.idstar.starbucks.databinding.FragmentStoreBinding

class StoreFragment : Fragment() {

    private var _binding: FragmentStoreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val storeViewModel = ViewModelProvider(this)[StoreViewModel::class.java]

        _binding = FragmentStoreBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textStore
        storeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}