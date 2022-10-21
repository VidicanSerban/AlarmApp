package com.example.alarmapp

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.btn)
        val editText = findViewById<EditText>(R.id.editTextNumber)
        fun isNumber(sec: String?): Boolean{
            return  if(sec.isNullOrBlank()) false
            else  sec.all{
                Character.isDigit(it)
            }
        }
        button.setOnClickListener{
            var sec = editText.text.toString()
            var i = Intent(applicationContext, MyBroadcastReceiver::class.java)
            if(isNumber(sec))
            {
                var sec: Int = editText.text.toString().toInt()
                var pi = PendingIntent.getBroadcast(applicationContext, 11, i,PendingIntent.FLAG_IMMUTABLE)
                var am: AlarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
                am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (sec*1000), pi)
                Toast.makeText(applicationContext, "Alarm is set for $sec Seconds", Toast.LENGTH_LONG).show()
            }
            else
                Toast.makeText(applicationContext, "Enter a valid value", Toast.LENGTH_SHORT).show()
        }
    }
}