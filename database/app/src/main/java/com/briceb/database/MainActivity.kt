package com.briceb.database

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val john = User(name = "John", age = 42)
        val maria = User(name = "Maria", age = 37)
        val gilles = User(name = "Gilles", age = 56)
        recyclerView.layoutManager = LinearLayoutManager(applicationContext)

        getDatabase(applicationContext)?.userDao()?.apply {
            insert(john, maria, gilles)
            recyclerView.adapter = UserAdapter(getUsers())

            }
        }

    fun importUser(view: View) {
        val user = User(name = view.editTxtName.toString(),age = view.editAge.toString().toInt())

    }

}


