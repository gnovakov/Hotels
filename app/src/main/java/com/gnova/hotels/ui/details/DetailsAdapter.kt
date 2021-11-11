package com.gnova.hotels.ui.details

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gnova.domain.models.RatePlan
import com.gnova.hotels.databinding.DetailRoomsItemBinding
import com.gnova.hotels.ui.noZeros
import com.gnova.hotels.ui.toPriceAmount

class DetailsAdapter() : ListAdapter<RatePlan, DetailsAdapter.DetailsViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailsViewHolder {
        return DetailsViewHolder(DetailRoomsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: DetailsViewHolder, position: Int) {
        val rates = getItem(position)

        holder.bind(rates)
    }


    class DetailsViewHolder(val binding: DetailRoomsItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(rates: RatePlan) {

            binding.roomNameTv.text = rates.name
            binding.roomDescriptionTv.text = rates.description
            binding.roomTypeTv.text = rates.rooms[0].type
            binding.roomPriceTv.text = rates.totalCost.amount?.toDouble()?.toPriceAmount()?.noZeros()

        }

    }



    companion object DiffCallback : DiffUtil.ItemCallback<RatePlan>() {

        override fun areItemsTheSame(oldItem: RatePlan, newItem: RatePlan): Boolean {
            return oldItem.totalCost.amount == newItem.totalCost.amount
        }

        override fun areContentsTheSame(oldItem: RatePlan, newItem: RatePlan): Boolean {
            return oldItem == newItem
        }
    }


}





