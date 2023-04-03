package com.example.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(_binding?.root)

        val list = ArrayList<ItemClass>()
        for (i in 0..9) {
            if (i == 0) {
                list.add(ItemClass(1, "Even"))
            } else {
                list.add(ItemClass(2, "Odd"))
            }
        }
        _binding?.recyclerView?.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        _binding?.recyclerView?.adapter = RVAdapter(list)
    }
}
