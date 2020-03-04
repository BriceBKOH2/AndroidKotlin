package com.briceb.learning_kotlin_android.List

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.briceb.learning_kotlin_android.R
import kotlinx.android.synthetic.main.activity_list_viewer.*

class ListViewerContact : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_viewer)

        val listContact = mutableListOf<Contact>()
        listContact.add(
            Contact(
                "John",
                19,
                R.drawable.man,
                true
            )
        )
        listContact.add(
            Contact(
                "Marie",
                22,
                R.drawable.woman,
                false
            )
        )
        listContact.add(
            Contact(
                "Jane",
                52,
                R.drawable.woman,
                true
            )
        )

        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.adapter =
            ContactAdapter(listContact)

    }
}
