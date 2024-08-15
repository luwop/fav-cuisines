package edu.uchicago.gerber.favs.data.repository

import edu.uchicago.gerber.favs.data.model.BusinessResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface YelpApi {

    @Headers("Authorization: Bearer SmsEr6ZGETcVSuGfp0zceNpPBKKL67iTWVPa1EF02uj9ejp0mXDkRc3tCIu5RpXc3y1AKiVLxeQu8LK7ar_ZCIOaRyCso1BDEm2_PMx6hY5KIzBoZUBKlBHOhUq9ZnYx")
    @GET("businesses/search")
    suspend fun getBusinesses(
        @Query("location") location: String = "Chicago",
        @Query("term") term: String,
        @Query("sort_by") sortBy: String = "best_match",
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Response<BusinessResponse>
}
