package edu.uchicago.gerber.favs.presentation.screens.search.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import edu.uchicago.gerber.favs.data.model.Business
import edu.uchicago.gerber.favs.data.repository.BusinessRepository

class BusinessSource(
    private val businessRepository: BusinessRepository,
    private val paginateData: Paginate
) : PagingSource<Int, Business>() {

    override fun getRefreshKey(state: PagingState<Int, Business>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Business> {
        return try {
            val offset = params.key ?: 0

            val response = businessRepository.getBusinesses(
                term = paginateData.query,
                limit = params.loadSize,
                offset = offset
            )

            if (response.isSuccessful) {
                val body = response.body()?.businesses ?: emptyList()
                LoadResult.Page(
                    data = body,
                    prevKey = if (offset == 0) null else offset - params.loadSize,
                    nextKey = if (body.size < params.loadSize) null else offset + params.loadSize
                )
            } else {
                LoadResult.Error(Exception(response.message()))
            }

        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    override val keyReuseSupported: Boolean
        get() = true
}
