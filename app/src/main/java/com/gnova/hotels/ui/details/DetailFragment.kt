package com.gnova.hotels.ui.details

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.gnova.domain.models.HotelAvailability
import com.gnova.domain.models.RatePlan
import com.gnova.hotels.App
import com.gnova.hotels.R
import com.gnova.hotels.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private lateinit var adapter: DetailsAdapter

    val args: DetailFragmentArgs by navArgs()

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().application as App).appComponent.inject(this)
        val binding = FragmentDetailBinding.bind(view)
        _binding = binding

        val hotel = args.hotel

        setupRecyclerView()

        populateHotelInfo(hotel)

        backArrowClick()
    }

    private fun populateHotelInfo(hotel: HotelAvailability) {

        Picasso.get()
            .load(hotel.hotelInfo.images[0].fileReference)
            .placeholder(R.drawable.loading_animation)
            .error(R.drawable.ic_broken_image)
            .into(binding.detailHotelImageIv)

        binding.detailHotelNameTv.text = hotel.hotelInfo.name
        binding.detailHotelAddressTv.text = hotel.hotelInfo.address.addressline1

        showRooms(hotel.ratePlans)

    }

    private fun showRooms(rates: List<RatePlan>) {
        adapter.submitList(rates)
    }

    private fun setupRecyclerView() {
        Log.d("TAG", "setupRecyclerView")
        adapter = DetailsAdapter()

        binding.detailRoomsRv.let {
            it.setHasFixedSize(true)
            it.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
            it.adapter = adapter
        }
    }

    private fun backArrowClick() {
        binding.photosToolbarIv.setOnClickListener {
            findNavController().navigate(
                DetailFragmentDirections.actionDetailFragmentToHotelsFragment()
            )
        }
    }




    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}

