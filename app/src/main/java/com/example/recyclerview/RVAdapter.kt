package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.RvItem2Binding
import com.example.recyclerview.databinding.RvItemBinding
import com.example.recyclerview.databinding.RvItemChildBinding

class RVAdapter(private val itemNo: List<ItemClass>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_ONE) {
            ItemViewHolder1(
                LayoutInflater.from(parent.context).inflate(R.layout.rv_item2, parent, false),
            )
        } else {
            return ItemViewHolder2(
                LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false),
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (itemNo[position] is ItemClass.ItemList) {
            val binding = RvItemBinding.bind(holder.itemView)
            binding.recyclerView3.adapter = RVChildAdapter((itemNo[position] as ItemClass.ItemList).data)
        } else if(itemNo[position] is ItemClass.ItemString) {
            val binding = RvItem2Binding.bind(holder.itemView)

            binding.textViewVertical.text = (itemNo[position] as ItemClass.ItemString).data
        }
    }

    override fun getItemViewType(position: Int): Int {
        return itemNo[position].viewType
    }

    inner class ItemViewHolder2(view: View) : RecyclerView.ViewHolder(view)

    inner class ItemViewHolder1(view: View) : RecyclerView.ViewHolder(view)

    override fun getItemCount(): Int {
        return itemNo.size
    }
}
