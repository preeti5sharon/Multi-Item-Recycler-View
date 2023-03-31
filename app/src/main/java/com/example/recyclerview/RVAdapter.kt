package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview.databinding.RvItem2Binding
import com.example.recyclerview.databinding.RvItemBinding

class RVAdapter(private val itemNo: ArrayList<ItemClass>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val VIEW_TYPE_ONE = 1
        const val VIEW_TYPE_TWO = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_ONE) {
            ItemViewHolder1(
                LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false),
            )
        } else {
            ItemViewHolder2(
                LayoutInflater.from(parent.context).inflate(R.layout.rv_item2, parent, false),
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

        if (itemNo[position].viewType == VIEW_TYPE_ONE) {
            val binding = RvItemBinding.bind(holder.itemView)

            binding.textView1.text = itemNo[position].data
        } else {
            val binding2 = RvItem2Binding.bind(holder.itemView)

            binding2.textView2.text = itemNo[position].data
        }
    }

    override fun getItemViewType(position: Int): Int {
        return itemNo[position].viewType
    }

    inner class ItemViewHolder2(view: View) : RecyclerView.ViewHolder(view)

    inner class ItemViewHolder1(view: View) : RecyclerView.ViewHolder(view)

    override fun getItemCount(): Int {
        return 10
    }
}
