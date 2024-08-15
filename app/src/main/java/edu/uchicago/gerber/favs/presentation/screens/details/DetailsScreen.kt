package edu.uchicago.gerber.favs.presentation.screens.details

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.skydoves.landscapist.glide.GlideImage
import edu.uchicago.gerber.favs.R
import edu.uchicago.gerber.favs.common.Constant
import edu.uchicago.gerber.favs.data.repository.Favorites
import edu.uchicago.gerber.favs.data.repository.FavoritesUtils
import edu.uchicago.gerber.favs.presentation.viewmodels.BusinessViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsScreen(
    businessViewModel: BusinessViewModel,
    navController: NavController
) {

    //observe the book
    val business = businessViewModel.business.value
    val activity = (LocalContext.current as? Activity)


    Scaffold(
        modifier = Constant.modifier,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color.Transparent
                ) ,
                title = {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Icon(imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Arrow Back",
                        modifier = Modifier
                            .clickable {
                                navController.popBackStack()
                            }
                            .align(Alignment.CenterVertically)
                            .padding(20.dp, 0.dp, 0.dp, 0.dp))

                    Text(
                        text = "Details",
                        modifier = Modifier
                            .align(Alignment.CenterVertically),
                        style = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold),
                        textAlign = TextAlign.Center,
                        fontSize = 25.sp
                    )

                    Row(
                        modifier = Modifier
                            .align(Alignment.CenterVertically)
                    ) {

                        Icon(imageVector = Icons.Default.Share,
                            contentDescription = "Share",
                            modifier = Modifier
                                .clickable {
                                    val sendIntent = Intent(Intent.ACTION_SEND)
                                    sendIntent.type = "text/plain"
                                    sendIntent.putExtra(
                                        Intent.EXTRA_TEXT,
                                        "You must check out this business!: ${business.name}"
                                    )
                                    activity?.startActivity(sendIntent)
                                }
                                .align(Alignment.CenterVertically)
                                .padding(10.dp, 0.dp, 0.dp, 0.dp))
                        Spacer(modifier = Modifier.width(20.dp))
                        Icon(painter = painterResource(id = R.drawable.ic_navigation),
                            contentDescription = "Map",

                            modifier = Modifier
                                .clickable {
                                    //this would be used for navigating if you have a physical address
                                    val coordinates = business.coordinates
                                    val intent = Intent(
                                        Intent.ACTION_VIEW,
                                        Uri.parse(
                                            "google.navigation:q=${coordinates.latitude},${coordinates.longitude}"
                                        )
                                    )
                                    activity?.startActivity(intent)
                                }
                                .align(Alignment.CenterVertically)
                                .padding(10.dp, 0.dp, 10.dp, 0.dp))
                        Spacer(modifier = Modifier.width(20.dp))
                        Icon(
                            imageVector = Icons.Default.Phone,
                            contentDescription = "Phone",
                            modifier = Modifier
                                .clickable {
                                    // Retrieve the phone number from the business object
                                    val phoneNumber = business.phone
                                    val intent = Intent(
                                        Intent.ACTION_DIAL,
                                        Uri.parse("tel:$phoneNumber")
                                    )
                                    activity?.startActivity(intent)
                                }
                                .align(Alignment.CenterVertically)
                                .padding(0.dp, 0.dp, 20.dp, 0.dp)
                        )
                    }

                }

            })
        }) {paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxHeight()
                .padding(paddingValues = paddingValues)
                .fillMaxWidth()
                .verticalScroll(state = rememberScrollState(0))
                .padding(20.dp, 0.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {


                Divider()
                Spacer(Modifier.height(20.dp))
                //we can use either coil or glide for images. If you need animations, use coil
                GlideImage(
                    modifier = Modifier
                        .fillMaxWidth()
                        .size(300.dp),
                    imageModel = business.imageUrl?.replace("http", "https") ?: "https://picsum.photos/id/1026/200/300",
                    // Crop, Fit, Inside, FillHeight, FillWidth, None
                    contentScale = ContentScale.Fit

                )
                with(business){
                    name?.let {
                        Text(
                            text = it,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            style = TextStyle(fontWeight = FontWeight.Bold),
                            textAlign = TextAlign.Start,
                            fontSize = 22.sp
                        )
                    }
                    alias?.let {
                        Text(
                            text = it,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            style = TextStyle(fontWeight = FontWeight.Normal),
                            textAlign = TextAlign.Start,
                            fontSize = 16.sp
                        )
                    }
                }

                Button(
                    modifier =
                    Modifier
                        .padding(10.dp, 0.dp)
                        .fillMaxWidth(1f),

                    onClick = {
                        // Create a Favorites object using the user's session email and the business details
                        val favorite = Favorites(
                            sessionEmail = businessViewModel.email.value ?: "",
                            name = business.name,
                            alias = business.alias,
                            imageUrl = business.imageUrl,
                            isClosed = business.isClosed,
                            url = business.url,
                            reviewCount = business.reviewCount,
                            categories = business.categories.map { it.title },
                            rating = business.rating,
                            coordinates = edu.uchicago.gerber.favs.data.repository.Coordinates(
                                latitude = business.coordinates.latitude,
                                longitude = business.coordinates.longitude
                            ),
                            transactions = business.transactions,
                            price = business.price,
                            phone = business.phone,
                            displayPhone = business.displayPhone,
                            distance = business.distance
                        )

                        // Use the FavoritesUtils to create a new favorite in the database
                        FavoritesUtils.createFavorite(favorite)

                        // Optionally show a Toast or log the action
//                        Toast.makeText(activity, "Added to Favorites", Toast.LENGTH_LONG).show()
                        Log.i("favorite", "Added to Favorites: $favorite")
                    },

                    colors =
                    ButtonDefaults.buttonColors(containerColor = Color.Green)
                ) {
                    Text(text = "Add to Favorites")
                }


            }
        }
    }

}