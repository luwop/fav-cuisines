package edu.uchicago.gerber.favs.presentation.screens.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import edu.uchicago.gerber.favs.authorization.AmplifyService
import edu.uchicago.gerber.favs.common.Constant
import edu.uchicago.gerber.favs.presentation.screens.search.paging.*
import edu.uchicago.gerber.favs.presentation.screens.search.paging.SearchOperation
import edu.uchicago.gerber.favs.presentation.viewmodels.BusinessViewModel
import edu.uchicago.gerber.favs.presentation.widgets.CustomBottomNavigationBar
import edu.uchicago.gerber.favs.presentation.widgets.CustomOutlinedTextField
import edu.uchicago.gerber.favs.presentation.widgets.CustomTopBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(
    businessViewModel: BusinessViewModel,
    navController: NavController,
    amplifyService: AmplifyService
) {
    val state = businessViewModel.searchState.value
    val queryText = businessViewModel.termText.value

    Scaffold(
        modifier = Constant.modifier,
        bottomBar = { CustomBottomNavigationBar(navController) },
        topBar = {
            CustomTopBar(titleText = "Search Cuisines",navController=navController, amplifyService=amplifyService)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues = paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            CustomOutlinedTextField(
                title = "Search Term",
                placeHolder = "e.g. pizza",
                textState = queryText,
                onTextChange = businessViewModel::setTermText,
                keyboardType = KeyboardType.Text,
                ImeAction.Search,
                businessViewModel::onSearch
            )

            Spacer(modifier = Modifier.height(10.dp))
            when (state.searchOperation) {
                SearchOperation.LOADING -> {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)
                    ) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .padding(12.dp)
                                .align(
                                    Alignment.Center
                                )
                        )
                    }
                }
                SearchOperation.DONE -> {
                    BusinessList(businessViewModel, navController)
                }
                else -> {
                    Box {}
                }
            }
        }
    }
}