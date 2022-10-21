package com.example.alarmapp

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AlarmOnActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var mp: MediaPlayer = MediaPlayer.create(applicationContext, R.raw.alarm_clock)
        mp.start()
        var stopbtn = findViewById<Button>(R.id.stopbtn)
        stopbtn.setOnClickListener{mp.stop()}

    }
}