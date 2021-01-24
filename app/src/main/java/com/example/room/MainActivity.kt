package com.example.room

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.room.database.AppDatabase
import com.example.room.models.User
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userDao = AppDatabase.getInstance(this).userDao()

        val tom = User("tom", "jack")
        val tony = User("tony", "white")

        btn_insert.setOnClickListener {
            userDao.insertAll(tom, tony)
        }
        btn_delete.setOnClickListener {
            userDao.delete(tom)
        }
        btn_update.setOnClickListener {
            val loadAllByIds = userDao.loadAllByIds(intArrayOf(1))
            Log.d("yue_qf", "loadAllByIds: $loadAllByIds")
        }
        btn_query.setOnClickListener {
            val user = userDao.findByName("tony", "white")
            Log.d("yue_qf", "user: $user")
        }
    }

}