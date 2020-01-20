package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fruits: ArrayList<Fruits> = ArrayList()
        fruits.add(Fruits("Apple", R.drawable.apple))
        fruits.add(Fruits("Banana", R.drawable.banana))
        fruits.add(Fruits("Peach", R.drawable.peach))
        fruits.add(Fruits("Watermelon", R.drawable.watermelon))
        fruits.add(Fruits("Avocado", R.drawable.avocado))



        val list = findViewById<ListView>(R.id.lvList)

        //val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, fruits)
        var adapter = AdapterCustom(this, fruits)
        list.adapter = adapter

        list.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            Toast.makeText(this, fruits.get(position).name, Toast.LENGTH_SHORT).show()
        }

    }
}
