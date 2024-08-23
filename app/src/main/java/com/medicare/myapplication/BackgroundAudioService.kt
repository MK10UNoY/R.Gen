package com.medicare.myapplication

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder

class BackgroundAudioService : Service() {

    private lateinit var mediaPlayer: MediaPlayer
//
//    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        mediaPlayer = MediaPlayer.create(this, R.raw.bgsong)
//        mediaPlayer.isLooping = true
//        mediaPlayer.start()
//
//        return START_STICKY
//    }

    override fun onDestroy() {
        mediaPlayer.stop()
        mediaPlayer.release()
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
