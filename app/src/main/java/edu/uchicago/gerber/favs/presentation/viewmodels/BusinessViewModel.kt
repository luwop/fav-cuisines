package edu.uchicago.gerber.favs.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import edu.uchicago.gerber.favs.common.Constant
import edu.uchicago.gerber.favs.data.model.Business
import edu.uchicago.gerber.favs.data.repository.BusinessRepository
import edu.uchicago.gerber.favs.data.repository.Favorites
import edu.uchicago.gerber.favs.data.repository.FavoritesUtils
import edu.uchicago.gerber.favs.data.repository.YelpApiProvider
import edu.uchicago.gerber.favs.presentation.screens.search.paging.BusinessSource
import edu.uchicago.gerber.favs.presentation.screens.search.paging.Paginate
import edu.uchicago.gerber.favs.presentation.screens.search.paging.SearchOperation
import edu.uchicago.gerber.favs.presentation.screens.search.paging.SearchState
import kotlinx.coroutines.launch

class BusinessViewModel: ViewModel() {
    private val businessRepository: BusinessRepository = BusinessRepository(YelpApiProvider.yelpApi())

    //////////////////////////////////////////
    // MUTABLE-STATES AND OBSERVABLE STATES for Businesses
    //////////////////////////////////////////
    private var _termText = mutableStateOf("")
    val termText: State<String> = _termText

    private var _business = mutableStateOf(Constant.fakeBusiness)
    val business: State<Business> = _business

    private val _searchState = mutableStateOf(SearchState())
    val searchState: State<SearchState> = _searchState

    //////////////////////////////////////////
    // MUTABLE-STATES AND OBSERVABLE STATES for AUTHENTICATION
    //////////////////////////////////////////
    private var _username = mutableStateOf("")
    val username: State<String> = _username

    private var _email = mutableStateOf("")
    val email: State<String> = _email

    private var _password = mutableStateOf("")
    val password: State<String> = _password

    private var _code = mutableStateOf("")
    val code: State<String> = _code

    private val _favoritesState = mutableStateOf<List<Favorites>>(emptyList())
    val favoritesState: State<List<Favorites>> = _favoritesState

    //////////////////////////////////////////
    // FUNCTIONS
    //////////////////////////////////////////
    fun setUsername(text: String){
        _username.value = text
    }
    fun setEmail(text: String){
        _email.value = text
    }

    fun setPassword(text: String){
        _password.value = text
    }

    fun setCode(text: String){
        _code.value = text
    }

    fun setBusiness(business: Business) {
        _business.value = business
    }

    fun setTermText(term: String) {
        _termText.value = term
    }

    fun fetchFavorites(sessionEmail: String) {
        FavoritesUtils.getAllFavorites(
            sessionEmail = sessionEmail,
            onSuccess = { favorites ->
                _favoritesState.value = favorites
            },
            onFailure = {
                Log.e("BusinessViewModel", "Failed to load favorites", it)
            }
        )
    }

    fun onSearch() {
        _searchState.value = SearchState(searchOperation = SearchOperation.LOADING)
        viewModelScope.launch {
            _searchState.value = SearchState(
                data = Pager(
                    config = PagingConfig(pageSize = 10, prefetchDistance = 5),
                    pagingSourceFactory = {
                        BusinessSource(
                            businessRepository = businessRepository,
                            paginateData = Paginate(
                                query = _termText.value,
                            )
                        )
                    }
                ).flow.cachedIn(viewModelScope),
                searchOperation = SearchOperation.DONE
            )
        }
    }




}