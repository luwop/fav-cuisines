package edu.uchicago.gerber.favs.data.repository

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

// Retrofit interface for Logging API endpoints
interface LoggingDB {

    @POST("/logging")
    fun createLog(@Body log: Logging): Call<Logging>
}

// Utility object to handle logging of events
object LoggingUtils {

    // Function to log events
    fun logEvent(sessionEmail: String, event: String) {
        val timestamp = System.currentTimeMillis() / 1000
        val logEntry = Logging(
            sessionEmail = sessionEmail,
            event = event,
            timestamp = timestamp
        )

        val loggingDB = DatabaseProviders.provideLoggingDB()

        val call = loggingDB.createLog(logEntry)

        call.enqueue(object : Callback<Logging> {
            override fun onResponse(call: Call<Logging>, response: Response<Logging>) {
                if (response.isSuccessful) {
                    Log.i("LoggingUtils", "Log entry created successfully: $logEntry")
                } else {
                    Log.e("LoggingUtils", "Failed to create log entry: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<Logging>, t: Throwable) {
                Log.e("LoggingUtils", "Error creating log entry", t)
            }
        })
    }
}
