package com.briceb.apicommunication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.briceb.apicommunication.api.QuestionsAdapter
import com.briceb.apicommunication.api.models.Question
import com.briceb.apicommunication.api.stackService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        stackService.getQuestions().enqueue(object : retrofit2.Callback<Question> {
            override fun onResponse(call: Call<Question>, response: Response<Question>) {
                Log.i("StackService", "Response : onResponse")
                if (response.isSuccessful) {
                    Log.i( "StackService", "Response : successfull")
                    val questions = response.body()

                    recyclerView.layoutManager = LinearLayoutManager(applicationContext)
                    if (questions != null) {
                        recyclerView.adapter =
                            QuestionsAdapter(questions.items)
                    }
                }
                else Log.i( "StackService", "Error : not successfull")
            }

            override fun onFailure(call: Call<Question>, t: Throwable) {
                Log.i( "StackService", "Error : onFailure")
            }

        })
    }
}
