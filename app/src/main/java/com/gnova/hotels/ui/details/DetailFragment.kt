package com.gnova.hotels.ui.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.gnova.domain.models.HotelAvailability
import com.gnova.hotels.App
import com.gnova.hotels.R
import com.gnova.hotels.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso

class DetailFragment : Fragment(R.layout.fragment_detail) {

    val args: DetailFragmentArgs by navArgs()

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().application as App).appComponent.inject(this)
        val binding = FragmentDetailBinding.bind(view)
        _binding = binding

        val hotel = args.hotel


        populateHotelInfo(hotel)
    }

    private fun populateHotelInfo(hotel: HotelAvailability) {

    }




    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}