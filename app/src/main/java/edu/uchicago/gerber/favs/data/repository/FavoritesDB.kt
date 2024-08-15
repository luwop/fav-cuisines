package edu.uchicago.gerber.favs.data.repository

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface FavoritesDB {

    @POST("/favorites")
    fun createFavorite(@Body favorite: Favorites): Call<Favorites>

    @DELETE("/favorites/{id}")
    fun deleteFavorite(@Path("id") id: String): Call<Void>

    @GET("/favorites/email/{sessionEmail}")
    fun getAllFavorites(@Path("sessionEmail") sessionEmail: String): Call<List<Favorites>>
}

object FavoritesApiProvider {

    private const val BASE_URL = "http://18.216.243.247:8081/"

    fun favoritesApi(): FavoritesDB {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FavoritesDB::class.java)
    }

    private fun getOkHttpClient() = OkHttpClient.Builder()
        .addInterceptor(getLoggingInterceptor())
        .build()

    private fun getLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
}

object FavoritesUtils {

    // Function to create a new favorite
    fun createFavorite(favorite: Favorites) {
        val favoritesDB = FavoritesApiProvider.favoritesApi()
        val call = favoritesDB.createFavorite(favorite)
        call.enqueue(object : Callback<Favorites> {
            override fun onResponse(call: Call<Favorites>, response: Response<Favorites>) {
                if (response.isSuccessful) {
                    Log.i("FavoritesUtils", "Favorite created successfully: ${response.body()}")
                } else {
                    Log.e("FavoritesUtils", "Failed to create favorite: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<Favorites>, t: Throwable) {
                Log.e("FavoritesUtils", "Error creating favorite", t)
            }
        })
    }

    // Function to delete a favorite by its ID
    fun deleteFavorite(id: String) {
        val favoritesDB = FavoritesApiProvider.favoritesApi()
        val call = favoritesDB.deleteFavorite(id)
        call.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    Log.i("FavoritesUtils", "Favorite deleted successfully: $id")
                } else {
                    Log.e("FavoritesUtils", "Failed to delete favorite: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.e("FavoritesUtils", "Error deleting favorite", t)
            }
        })
    }

    // Function to fetch all favorites for a specific sessionEmail
    fun getAllFavorites(sessionEmail: String, onSuccess: (List<Favorites>) -> Unit, onFailure: (Throwable) -> Unit) {
        val favoritesDB = FavoritesApiProvider.favoritesApi()
        val call = favoritesDB.getAllFavorites(sessionEmail)
        call.enqueue(object : Callback<List<Favorites>> {
            override fun onResponse(call: Call<List<Favorites>>, response: Response<List<Favorites>>) {
                if (response.isSuccessful) {
                    response.body()?.let { favorites ->
                        onSuccess(favorites)
                    } ?: run {
                        Log.e("FavoritesUtils", "Failed to fetch favorites: empty response")
                        onFailure(Throwable("Failed to fetch favorites: empty response"))
                    }
                } else {
                    Log.e("FavoritesUtils", "Failed to fetch favorites: ${response.errorBody()?.string()}")
                    onFailure(Throwable("Failed to fetch favorites: ${response.errorBody()?.string()}"))
                }
            }

            override fun onFailure(call: Call<List<Favorites>>, t: Throwable) {
                Log.e("FavoritesUtils", "Error fetching favorites", t)
                onFailure(t)
            }
        })
    }
}
