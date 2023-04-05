package com.example.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(_binding?.root)

        val list = ArrayList<ItemClass>()
        val childList = ArrayList<String>()
        for (i in 0..50) {
            list.add(ItemClass.ItemString("$i"))
        }
        for (i in 100..120) {
            childList.add("Horizontal $i")
        }
        list.add(0, ItemClass.ItemList(childList))
        _binding?.recyclerView?.adapter = RVAdapter(list)
    }
}
