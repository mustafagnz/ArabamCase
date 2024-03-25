package com.example.arabamcase.adapter

import android.renderscript.ScriptGroup.Binding
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.findNavController
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.arabamcase.databinding.CardItemBinding
import com.example.arabamcase.model.list.Advert



class AdvertListAdapter : PagingDataAdapter<Advert, AdvertListAdapter.ImageViewHolder>(diffCallback){

    inner class ImageViewHolder (
        val bindig: CardItemBinding
    ): RecyclerView.ViewHolder(bindig.root)

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<Advert>() {
            override fun areItemsTheSame(
                oldItem: Advert, newItem: Advert
            ): Boolean {
                return oldItem.modelName == newItem.modelName
            }

            override fun areContentsTheSame(
                oldItem: Advert, newItem: Advert
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val item = getItem(position)

        holder.bindig.apply {

            holder.itemView.apply {
                titleText.text = "${item?.title}"
                cityText.text = "${item?.location?.cityName}"
                locationText.text = "${item?.location?.townName}"
                priceText.text = "${item?.price}"


            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        return ImageViewHolder(
            CardItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    }


}