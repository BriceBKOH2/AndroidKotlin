package com.briceb.learning_kotlin_android.List

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.briceb.learning_kotlin_android.R
import kotlinx.android.synthetic.main.activity_list_viewer.*

class ListViewerMovie : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_viewer)

        val listMovies = mutableListOf<Movie>()
        listMovies.add(
            Movie(
                "Matrix",
                1999
            )
        )
        listMovies.add(
            Movie(
                "Mon Voisin Totoro",
                1988
            )
        )
        listMovies.add(
            Movie(
                "Le seigneur de les anneaux",
                2006
            )
        )

        recyclerView.layoutManager = LinearLayoutManager(applicationContext)
        recyclerView.adapter =
            MovieAdapter(listMovies)

    }
}
