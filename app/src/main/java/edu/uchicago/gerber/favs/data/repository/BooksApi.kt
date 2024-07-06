package edu.uchicago.gerber.favs.data.repository

import edu.uchicago.gerber.favs.data.models.VolumesResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface BooksApi {

    //https://developers.google.com/books/docs/v1/using
    //https://square.github.io/retrofit/

    //this will manage generating the query string and using Retrofit to send GET request to api
    //The google books api does not require a key, but most APIs do.
    //@Headers("Authorization: Bearer [your key]")
    @GET(value = "books/v1/volumes")
    suspend fun getBooks(
        @Query("q") query: String,
        @Query("maxResults") maxResults: Int,
        @Query("startIndex") startIndex: Int,
    ): Response<VolumesResponse>

}