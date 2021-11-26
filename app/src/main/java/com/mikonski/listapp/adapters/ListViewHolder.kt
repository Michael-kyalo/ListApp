package com.mikonski.listapp.adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mikonski.listapp.R

class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val listText = itemView.findViewById(R.id.textView) as TextView
    val test = "Test"
}