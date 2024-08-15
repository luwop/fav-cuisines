package edu.uchicago.gerber.favs.data.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object EmailProvider {

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://mimddv44w9.execute-api.us-east-2.amazonaws.com/Prod/mail") // Replace with your actual API Gateway URL
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: Email by lazy {
        retrofit.create(Email::class.java)
    }
}
