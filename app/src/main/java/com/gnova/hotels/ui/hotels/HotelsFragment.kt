package com.gnova.hotels.ui.hotels

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.gnova.hotels.App
import com.gnova.hotels.R
import com.gnova.hotels.databinding.FragmentHotelsBinding

class HotelsFragment : Fragment(R.layout.fragment_hotels) {

    private var _binding: FragmentHotelsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().application as App).appComponent.inject(this)
        val binding = FragmentHotelsBinding.bind(view)
        _binding = binding


    }

}