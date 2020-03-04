package com.briceb.apicommunication.api

import com.briceb.apicommunication.api.models.Question
import retrofit2.Call
import retrofit2.http.GET

interface StackService {
    @GET( "questions?order=desc&sort=activity&site=stackoverflow")
    fun getQuestions() : Call<Question>
}