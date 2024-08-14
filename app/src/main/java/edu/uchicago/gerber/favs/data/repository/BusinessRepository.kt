package edu.uchicago.gerber.favs.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class BusinessRepository( private val yelpApi: YelpApi) {
    suspend fun getBusinesses(
        term: String,
        offset: Int
    ) {
        return withContext(Dispatchers.IO) {
            yelpApi.getBusinesses(term = term, offset = offset)
        }
    }

}