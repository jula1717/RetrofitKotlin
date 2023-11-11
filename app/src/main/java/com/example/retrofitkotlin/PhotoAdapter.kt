package com.example.retrofitkotlin

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.retrofitkotlin.databinding.ItemPhotoBinding

class PhotoAdapter : PagingDataAdapter<Photo, PhotoAdapter.PhotoViewHolder>(DiffCallback()) {
    class PhotoViewHolder(private val binding: ItemPhotoBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(photo: Photo) {
            binding.apply {
                Glide.with(itemView).load(photo.urls.regular).centerCrop().transition(DrawableTransitionOptions.withCrossFade()).error(R.drawable.ic_error).into(imageView)
                textViewUserName.text = photo.user.username
            }
    }

}

    class DiffCallback : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean = oldItem.id==newItem.id
        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean = oldItem==newItem

    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val currentItem = getItem(position)
        if(currentItem!=null) holder.bind(currentItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PhotoViewHolder(binding)
    }
}