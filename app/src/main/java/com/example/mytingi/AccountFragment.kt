package com.example.mytingi

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth


class AccountFragment : Fragment() {

    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val b = inflater.inflate(R.layout.fragment_account, container, false)
        val email1 = b.findViewById<TextView>(R.id.email1)
        val username1 = b.findViewById<TextView>(R.id.username1)
        var cont = b.findViewById<TextView>(R.id.cont)
        val edituser = b.findViewById<ImageButton>(R.id.edituser)
        val editcont = b.findViewById<ImageButton>(R.id.editcont)

        val user = FirebaseAuth.getInstance().currentUser
        if (user != null) {
            var userEmail = user.email
            email1.text = userEmail
            username1.text = userEmail?.replace("@gmail.com", "")
        } else {
            // No user is signed in
        }

        edituser.setOnClickListener{
            val alert: AlertDialog.Builder = activity?.let { it1 -> AlertDialog.Builder(it1) }!!
            alert.setTitle("Edit")
            alert.setMessage("Username")
            val input = EditText(activity)

            alert.setView(input)

            alert.setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, whichButton ->
                // Do something with value!
                val value = input.text.toString()
                username1.text = value
            })

            alert.setNegativeButton("Cancel",
                DialogInterface.OnClickListener { dialog, whichButton ->
                    // Canceled.
                })
            alert.show()

        }
        editcont.setOnClickListener{
            val alert: AlertDialog.Builder = activity?.let { it1 -> AlertDialog.Builder(it1) }!!
            alert.setTitle("Edit")
            alert.setMessage("Contact")

            val input = EditText(activity)

            alert.setView(input)

            alert.setPositiveButton("Ok", DialogInterface.OnClickListener { dialog, whichButton ->
                // Do something with value!
                val value = input.text.toString()
                cont.text = value
            })

            alert.setNegativeButton("Cancel",
                DialogInterface.OnClickListener { dialog, whichButton ->
                    // Canceled.
                })
            alert.show()



        }




        val button1 = b.findViewById<Button>(R.id.edit1)
        button1.setOnClickListener{
            val intent = Intent(activity, MainActivity2::class.java)
            startActivity(intent)
        }









        // Inflate the layout for this fragment
        return b


    }

}