package com.mikonski.listapp.adapters

import android.view.LayoutInflater
import android.view.OrientationEventListener
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mikonski.listapp.R
import com.mikonski.listapp.classes.Task

class ListRecyclerViewAdapter(private val list: ArrayList<Task>, val listener: ClickListener) : RecyclerView.Adapter<ListViewHolder>(){
    interface ClickListener {
        fun listItemClicked(task: Task)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.test_item, parent, false)

        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
      holder.listText.setText(list[position].name)
        holder.itemView.setOnClickListener {
            listener.listItemClicked(list[position])
        }
    }

    override fun getItemCount(): Int {
         return list.size
    }

    fun addList(task: Task) {

        list.add(task)
        notifyItemInserted(list.size - 1)

    }
}
