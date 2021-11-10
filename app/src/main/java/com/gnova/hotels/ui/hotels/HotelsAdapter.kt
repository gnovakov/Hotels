package com.gnova.hotels.ui.hotels

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gnova.domain.models.HotelAvailability
import com.gnova.hotels.R
import com.gnova.hotels.databinding.HotelItemBinding
import com.squareup.picasso.Picasso

class HotelsAdapter(
    private val onClickListener: OnClickListener
) : ListAdapter<HotelAvailability, HotelsAdapter.HotelsViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelsViewHolder {
        return HotelsViewHolder(HotelItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: HotelsViewHolder, position: Int) {
        val hotels = getItem(position)
        holder.itemView.setOnClickListener {
            onClickListener.onClick(hotels)
        }
        holder.bind(hotels)
    }

    class HotelsViewHolder(val binding: HotelItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(hotel: HotelAvailability) {



            binding.hotelNameTv.text = hotel.hotelInfo.name
            binding.hotelDescriptionTv.text = hotel.hotelInfo.headline

            Picasso.get()
                .load(hotel.hotelInfo.images[0].fileReference)
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image)
                .into(binding.hotelImageIv)

            Picasso.get()
                .load(hotel.hotelInfo.tripAdvisor.ratingImageUrl)
                .placeholder(R.drawable.loading_animation)
                .error(R.drawable.ic_broken_image)
                .into(binding.tripAdvisorIv)
        }

    }



    companion object DiffCallback : DiffUtil.ItemCallback<HotelAvailability>() {

        override fun areItemsTheSame(oldItem: HotelAvailability, newItem: HotelAvailability): Boolean {
            return oldItem.hotelInfo.address.postcode == newItem.hotelInfo.address.postcode
        }

        override fun areContentsTheSame(oldItem: HotelAvailability, newItem: HotelAvailability): Boolean {
            return oldItem == newItem
        }
    }

    class OnClickListener(val clickListener: (hotel: HotelAvailability) -> Unit) {
        fun onClick(hotel: HotelAvailability) = clickListener(hotel)
    }

}





