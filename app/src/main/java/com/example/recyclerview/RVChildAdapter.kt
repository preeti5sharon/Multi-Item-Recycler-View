package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.RvItemChildBinding

class RVChildAdapter(val childItemList: List<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item_child, parent, false)
        return ChildViewHolder(view)
    }

    override fun getItemCount(): Int {
        return childItemList.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val binding = RvItemChildBinding.bind(holder.itemView)
        binding.text3.text = childItemList[position]
    }

    inner class ChildViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
