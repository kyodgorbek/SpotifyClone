package com.example.spotifyclone.exoplayer.callbacks

import android.widget.Toast
import com.example.spotifyclone.exoplayer.MusicService
import com.google.android.exoplayer2.PlaybackException
import com.google.android.exoplayer2.Player

class MusicPlayerEventListener(
    private val musicService: MusicService
):Player.Listener {
    override fun onPlaybackStateChanged(playbackState: Int) {
        super.onPlaybackStateChanged(playbackState)
        if(playbackState == Player.STATE_READY){
            musicService.stopForeground(false)
        }

    }
        override fun onPlayerError(error: PlaybackException) {
            super.onPlayerError(error)
            Toast.makeText(musicService, "Unknown error occurred", Toast.LENGTH_LONG).show()
        }
    }

