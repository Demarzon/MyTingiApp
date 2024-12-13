package com.example.mytingi

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.content.Intent

import android.graphics.BitmapFactory
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.NotificationCompat
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class SettingsFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val s = inflater.inflate(R.layout.fragment_settings, container, false)


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requestPermissions(arrayOf(Manifest.permission.POST_NOTIFICATIONS), 0)
        }

        val button2 = s.findViewById<Button>(R.id.back2main)
        button2.setOnClickListener{
            val intent = Intent(activity, MainActivity2::class.java)
            startActivity(intent)
        }


        var switch1 = s.findViewById<Switch>(R.id.switch1)
        switch1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(activity, "Notification enabled", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "Notification disabled", Toast.LENGTH_SHORT).show()

            }
        }



        // Inflate the layout for this fragment
        return s
    }
    override public fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {if(grantResults.isEmpty() || grantResults[0] != PackageManager.PERMISSION_GRANTED){
        Toast.makeText(activity, "Permission granted", Toast.LENGTH_SHORT).show()
    }else{
        Toast.makeText(activity, "Permission denied", Toast.LENGTH_SHORT).show()

    }




    }
}