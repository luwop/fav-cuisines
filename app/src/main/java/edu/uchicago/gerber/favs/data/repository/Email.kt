package edu.uchicago.gerber.favs.data.repository

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

data class EmailRequest(
    val subject: String,
    val email: String,
    val body: String
)

interface Email {

    @Headers("Content-Type: application/json")
    @POST("mail")
    fun sendEmail(@Body request: EmailRequest): Call<Void>
}
