package com.example.spotifyclone.adapters

import androidx.recyclerview.widget.AsyncListDiffer
import com.example.spotifyclone.R
import com.example.spotifyclone.databinding.SwipeItemBinding

class SwipeSongAdapter : BaseSongAdapter(R.layout.swipe_item) {
    lateinit var binding: SwipeItemBinding
    override val differ = AsyncListDiffer(this, diffCallback)

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        binding = SwipeItemBinding.bind(holder.itemView)
        val song = songs[position]

        binding.root.apply {
            val text = "${song.title} - ${song.subtitle}"
            binding.tvPrimary.text = text

            setOnClickListener {
                onItemClickListener?.let { click ->
                    click(song)
                }
            }
        }
    }

}