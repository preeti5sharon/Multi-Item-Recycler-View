package com.example.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class RVAdapter(itemNo: Int) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val itemNo = itemNo
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == 1) {
            return ItemViewHolder1(
                LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false),
            )
        }
        return ItemViewHolder2(
            LayoutInflater.from(parent.context).inflate(R.layout.rv_item2, parent, false),
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (itemNo == 1) {
            (holder as ItemViewHolder1)
        } else {
            (holder as ItemViewHolder2)
        }
    }

    inner class ItemViewHolder2(view: View) : RecyclerView.ViewHolder(view)

    inner class ItemViewHolder1(view: View) : RecyclerView.ViewHolder(view)

    override fun getItemCount(): Int {
        return 10
    }
}
