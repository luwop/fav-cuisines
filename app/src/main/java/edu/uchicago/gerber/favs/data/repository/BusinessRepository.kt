package edu.uchicago.gerber.favs.data.repository

import edu.uchicago.gerber.favs.data.model.BusinessResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class BusinessRepository( private val yelpApi: YelpApi) {
    suspend fun getBusinesses(
        term: String,
        limit: Int,
        offset: Int
    ):Response<BusinessResponse> {
        return withContext(Dispatchers.IO) {
            yelpApi.getBusinesses (
                term = term,
                limit = limit,
                offset = offset
            )
        }
    }

}