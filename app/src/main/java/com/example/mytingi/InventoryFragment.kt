package com.example.mytingi

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView


class InventoryFragment : Fragment() {



    private var items = mutableListOf<Item>()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?



    ): View? {
        val a = inflater.inflate(R.layout.fragment_inventory, container, false)

        val categorySpinner = a.findViewById<Spinner>(R.id.categorySpinner)




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

      items = mutableListOf(
            Item("Item 1", "delicate", button1, textView1),
            Item("Item 2", "sensitive", button2, textView2),
            Item("Item 3", "delicate", button3, textView3),
            Item("Item 4", "sensitive", button4, textView4),
            Item("Item 5", "delicate", button5, textView5),
            Item("Item 6", "sensitive", button6, textView6),
          Item("Item 7", "delicate", button7, textView7),
          Item("Item 8", "sensitive", button8, textView8),
          Item("Item 9", "delicate", button9, textView9)

           // ... Add all your items with their categories
        )

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.category_array, // Define this array in strings.xml
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            categorySpinner.adapter = adapter
        }

        categorySpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedCategory = parent?.getItemAtPosition(position).toString()
                filterItemsByCategory(selectedCategory)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle case where nothing is selected (e.g., show all items)
                filterItemsByCategory("All")
            }
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
    private fun filterItemsByCategory(category: String) {
        val filteredItems = if (category == "All") {
            items
        } else {
            items.filter { it.category == category }
        }

        for (item in items) {
            val isVisible = filteredItems.contains(item)
            item.imageButton.visibility = if (isVisible) View.VISIBLE else View.GONE
            item.textView.visibility = if (isVisible) View.VISIBLE else View.GONE
        }
    }








}