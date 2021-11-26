package com.mikonski.listapp.utils

import android.content.Context
import com.mikonski.listapp.classes.Task

class TaskDataManager(private val context: Context) {
    fun saveTask(task: Task) {
         val tasks = getTasks()
        tasks.add(task)
    }

    fun getTasks() : ArrayList<Task>{
      //  val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val  content = HashMap<String, HashSet<String>>()
        val  tasks = ArrayList<Task>()

        for (task in content) {
            val taskHashSet = ArrayList(HashSet<String>())
            val item = Task(task.key, taskHashSet)

            tasks.add(item)
        }

        return tasks
    }
}