package edu.uchicago.gerber.favs.data.repository

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface YelpApi {

    @Headers("Authorization: Bearer k_g9GmmJQqWt-sicHKG8BfJqidSgSPYZ50CEq1aXAf2FOQlT-gw03CmjHWLo0DMaVg_WyRCMg8FBF9TSBtXxDfsNv6WDdHSmiWuqo56NuUrA1t-TnIqFSAYsNg2VZnYx")
    @GET("businesses/search")
     suspend fun  getBusinesses(
         @Query("location") location: String = "Chicago",
         @Query("term") term: String,
         @Query("sort_by") sortBy: String = "best_match",
         @Query("limit") limit: Int = 20,
         @Query("offset") offset: Int = 0
     )
}