package com.example.mytingi

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat


class MainActivity3 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        createNotificationChannel()
        // Get the Intent that started this activity and extract the string


        val btn1 = findViewById<ImageButton>(R.id.back1)
        val notif = findViewById<Button>(R.id.notif1)


        btn1.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        val txt1 = findViewById<TextView>(R.id.txt1)
        var message = intent.getStringExtra("message")
        var capacity = findViewById<ImageView>(R.id.capacity)
        var status = findViewById<TextView>(R.id.status)
        var temp = findViewById<TextView>(R.id.temp)
        var moisture = findViewById<TextView>(R.id.moisture)

        txt1.text = message





        when (message) {
            "Brand A" -> {
                capacity.setImageResource(R.drawable.capfull)
                status.text = "Status: Full"
                temp.text = "Temp: 25°C"
                moisture.text = "Moisture: 60%"
            }

            "Brand B" -> {
                capacity.setImageResource(R.drawable.capmed)
                status.text = "Status: Medium"
                temp.text = "Temp: 20°C"
                moisture.text = "Moisture: 50%"
            }

            "Brand C" -> {
                capacity.setImageResource(R.drawable.capfull)
                status.text = "Status: Full"
                temp.text = "Temp: 30°C"
                moisture.text = "Moisture: 30%"
            }

            "Brand D" -> {
                capacity.setImageResource(R.drawable.caplow)
                status.text = "Status: LOW"
                temp.text = "Temp: 25°C"
                moisture.text = "Moisture: 50%"


            }

            "Brand E" -> {
                capacity.setImageResource(R.drawable.capmed)
                status.text = "Status: MEDIUM"
                temp.text = "Temp: 25°C"
                moisture.text = "Moisture: 50%"


            }

            "Brand F" -> {
                capacity.setImageResource(R.drawable.caplow)
                status.text = "Status: LOW"
                temp.text = "Temp: 25°C"
                moisture.text = "Moisture: 50%"

            }

            "Brand G" -> {
                capacity.setImageResource(R.drawable.capfull)
                status.text = "Status: Full"
                temp.text = "Temp: 25°C"
                moisture.text = "Moisture: 50%"
            }

            "Brand H" -> {
                capacity.setImageResource(R.drawable.caplow)
                status.text = "Status: LOW"
                temp.text = "Temp: 25°C"
                moisture.text = "Moisture: 50%"

            }

            "Brand I" -> {
                capacity.setImageResource(R.drawable.capfull)
                status.text = "Status: Full"
                temp.text = "Temp: 25°C"
                moisture.text = "Moisture: 50%"

            }
        }

        notif.setOnClickListener {
            showNotification()

        }


    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = getString(R.string.channel_name) // Get channel name from strings.xml
            val descriptionText =
                getString(R.string.channel_description) // Get channel description from strings.xml
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel("CHANNEL_ID", name, importance).apply {
                description = descriptionText
            }
            val notificationManager: NotificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun buildNotification(): Notification {
        val intent = Intent(this, MainActivity3::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }
        val pendingIntent: PendingIntent =
            PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_IMMUTABLE)
        val builder = NotificationCompat.Builder(this, "CHANNEL_ID")
            .setSmallIcon(R.drawable.tinig_logo) // Replace with your icon
            .setContentTitle("Your goods status")
            .setContentText("The status of your goods")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        // Add any other desired notification properties here, such as:
        // .setContentIntent(pendingIntent) // To launch an activity when tapped
        // .setAutoCancel(true) // To automatically dismiss the notification when tapped

        return builder.build()
    }

    // Function to show the notification
    private fun showNotification() {
        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(1, buildNotification())
    }


}
