package edu.uchicago.gerber.favs.presentation.screens.search.paging

import androidx.paging.PagingData
import edu.uchicago.gerber.favs.data.model.Business
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchOperation: SearchOperation = SearchOperation.INITIAL,
    val data: Flow<PagingData<Business>>? = null
)

enum class SearchOperation { LOADING, INITIAL, DONE }