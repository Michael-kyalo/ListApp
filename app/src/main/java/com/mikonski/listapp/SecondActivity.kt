package com.mikonski.listapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mikonski.listapp.MainActivity.Companion.KEY
import com.mikonski.listapp.classes.Task

class SecondActivity : AppCompatActivity() {
    private val TAG = "SecondActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

       val  task = intent.getParcelableExtra<Task>(KEY)
        val title = task?.name

        Log.d(TAG, "onCreate: $title")

    }
}