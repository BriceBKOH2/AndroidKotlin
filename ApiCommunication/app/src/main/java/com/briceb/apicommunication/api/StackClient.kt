package com.briceb.apicommunication.api

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val  baseUrl = "https://api.stackexchange.com/2.2/"

    val stackService : StackService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(OkHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return@lazy retrofit.create(StackService::class.java)
    }
