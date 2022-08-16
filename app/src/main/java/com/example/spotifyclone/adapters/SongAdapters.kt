package com.example.spotifyclone.adapters

import androidx.recyclerview.widget.AsyncListDiffer

import com.bumptech.glide.RequestManager
import com.example.spotifyclone.R
import com.example.spotifyclone.databinding.ListItemBinding

import javax.inject.Inject


class SongAdapter @Inject constructor(
    private val glide: RequestManager
) : BaseSongAdapter(R.layout.list_item) {
    lateinit var binding:ListItemBinding
    override val differ = AsyncListDiffer(this, diffCallback)

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        binding = ListItemBinding.bind(holder.itemView)
        val song = songs[position]
        binding.root.apply {
            binding.tvPrimary.text = song.title
            binding.tvSecondary.text = song.subtitle
            glide.load(song.imageUrl).into(binding.ivItemImage)

            setOnClickListener {
                onItemClickListener?.let { click ->
                    click(song)
                }
            }
        }
    }

}




