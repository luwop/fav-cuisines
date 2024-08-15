package edu.uchicago.gerber.favs.data.repository

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object DatabaseProviders {

    private const val LOGGING_BASE_URL = "http://18.216.243.247:8082/"
    private const val FAVORITES_BASE_URL = "http://18.216.243.247:8081/"

    fun provideLoggingDB(): LoggingDB {
        return Retrofit.Builder()
            .baseUrl(LOGGING_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(LoggingDB::class.java)
    }

    fun provideFavoritesDB(): FavoritesDB {
        return Retrofit.Builder()
            .baseUrl(FAVORITES_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FavoritesDB::class.java)
    }
}
