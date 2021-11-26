package com.mikonski.listapp

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mikonski.listapp.adapters.ListRecyclerViewAdapter

import com.mikonski.listapp.classes.Task
import com.mikonski.listapp.utils.TaskDataManager

class MainActivity : AppCompatActivity() , ListRecyclerViewAdapter.ClickListener{
    lateinit var listRecyclerView: RecyclerView
    lateinit var fab: FloatingActionButton
    val taskDataManager : TaskDataManager = TaskDataManager(this)
    val tasks = taskDataManager.getTasks()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listRecyclerView = findViewById(R.id.rec)
        fab = findViewById(R.id.fab)

        listRecyclerView.layoutManager = LinearLayoutManager(this)

        listRecyclerView.adapter = ListRecyclerViewAdapter(tasks,this)


        fab.setOnClickListener{
            showDialog()
        }
    }

    private fun showDialog () {
        val builder =  AlertDialog.Builder(this)
        val valueEditText = EditText(this)

        builder.setTitle("Add note")
        builder.setView(valueEditText)

        builder.setPositiveButton("save") { dialog, _ ->
            val  task = Task(valueEditText.text.toString())
            taskDataManager.saveTask(task)

            val recyclerViewAdapter = listRecyclerView.adapter as ListRecyclerViewAdapter

            recyclerViewAdapter.addList(task)
            dialog.dismiss()
            showTaskDetails(task)
        }
        builder.create().show()
    }
    private  fun  showTaskDetails(task: Task){
        val taskDetailIntent = Intent(this,SecondActivity::class.java)
        taskDetailIntent.putExtra(KEY, task)
    }
    companion object {
        const val KEY = "task"
    }

    override fun listItemClicked(task: Task) {
        showTaskDetails(task)
    }
}

