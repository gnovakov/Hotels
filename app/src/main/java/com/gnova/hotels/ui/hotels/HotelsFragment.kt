package com.gnova.hotels.ui.hotels

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.gnova.domain.models.HotelAvailability
import com.gnova.hotels.App
import com.gnova.hotels.R
import com.gnova.hotels.ViewModelFactory
import com.gnova.hotels.databinding.FragmentHotelsBinding
import javax.inject.Inject

class HotelsFragment : Fragment(R.layout.fragment_hotels) {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory<HotelsViewModel>
    private lateinit var viewModel: HotelsViewModel
    private val adapter: HotelsAdapter by lazy {
        HotelsAdapter(
            HotelsAdapter.OnClickListener{
                onItemClicked(it)
            }
        )
    }

    private var _binding: FragmentHotelsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().application as App).appComponent.inject(this)
        val binding = FragmentHotelsBinding.bind(view)
        _binding = binding

        viewModel = ViewModelProvider(this, viewModelFactory).get(HotelsViewModel::class.java)

        setupRecyclerView()

        viewModel.onViewLoaded()

        observeviewState()

    }

    private fun observeviewState() {
        viewModel.viewState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is HotelsViewState.Loading -> {
                    binding.statusImageIv.visibility = View.VISIBLE
                    binding.statusImageIv.setImageResource(R.drawable.loading_animation)
                }
                is HotelsViewState.Error -> {
                    binding.statusImageIv.visibility = View.VISIBLE
                    binding.statusImageIv.setImageResource(R.drawable.ic_connection_error)
                }
                is HotelsViewState.Presenting -> {
                    binding.statusImageIv.visibility = View.GONE
                    showHotels(it.hotels)
                }
            }
        })
    }

    private fun showHotels(hotels: List<HotelAvailability>) {
        adapter.submitList(hotels)
    }

    private fun setupRecyclerView() {
        Log.d("TAG", "setupRecyclerView")
        binding.hotelRv.let {
            it.setHasFixedSize(true)
            it.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
            it.adapter = adapter
        }
    }

    private fun onItemClicked(hotel: HotelAvailability) {
        Log.d("TAG", "Item Clicked")
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

}