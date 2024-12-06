package com.example.mytingi

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView


class InventoryFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?



    ): View? {
        val a = inflater.inflate(R.layout.fragment_inventory, container, false)


        val button1 = a.findViewById<ImageButton>(R.id.item1)
        val button2 = a.findViewById<ImageButton>(R.id.item2)
        val button3 = a.findViewById<ImageButton>(R.id.item3)
        val button4 = a.findViewById<ImageButton>(R.id.item4)
        val button5 = a.findViewById<ImageButton>(R.id.item5)
        val button6 = a.findViewById<ImageButton>(R.id.item6)
        val button7 = a.findViewById<ImageButton>(R.id.item7)
        val button8 = a.findViewById<ImageButton>(R.id.item8)
        val button9 = a.findViewById<ImageButton>(R.id.item9)

        val textView1 = a.findViewById<TextView>(R.id.textView1)
        val textView2 = a.findViewById<TextView>(R.id.textView2)
        val textView3 = a.findViewById<TextView>(R.id.textView3)
        val textView4 = a.findViewById<TextView>(R.id.textView4)
        val textView5 = a.findViewById<TextView>(R.id.textView5)
        val textView6 = a.findViewById<TextView>(R.id.textView6)
        val textView7 = a.findViewById<TextView>(R.id.textView7)
        val textView8 = a.findViewById<TextView>(R.id.textView8)
        val textView9 = a.findViewById<TextView>(R.id.textView9)

        var message ="";
        fun sendmessage(){
            var intent = Intent(activity, MainActivity3::class.java)
            intent.putExtra("message", message)
            startActivity(intent)
        }


        button1.setOnClickListener{
            message = textView1.text.toString()
            sendmessage()
        }
        button2.setOnClickListener{
           message = textView2.text.toString()
            sendmessage()
        }
        button3.setOnClickListener{
            message = textView3.text.toString()
            sendmessage()
        }
        button4.setOnClickListener{
            message = textView4.text.toString()
            sendmessage()
        }
        button5.setOnClickListener{
            message = textView5.text.toString()
            sendmessage()
        }
        button6.setOnClickListener{
            message = textView6.text.toString()
            sendmessage()
        }
        button7.setOnClickListener{
            message = textView7.text.toString()
            sendmessage()
        }
        button8.setOnClickListener{
            message = textView8.text.toString()
            sendmessage()
        }
        button9.setOnClickListener{
            message = textView9.text.toString()
            sendmessage()
        }










        // Inflate the layout for this fragment
        return a
    }







}