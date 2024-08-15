package edu.uchicago.gerber.favs.presentation.screens.contact

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import edu.uchicago.gerber.favs.authorization.AmplifyService
import edu.uchicago.gerber.favs.common.Constant
import edu.uchicago.gerber.favs.presentation.widgets.CustomBottomNavigationBar
import edu.uchicago.gerber.favs.presentation.widgets.CustomTopBar
import edu.uchicago.gerber.favs.data.repository.EmailProvider
import edu.uchicago.gerber.favs.data.repository.EmailRequest
import edu.uchicago.gerber.favs.presentation.viewmodels.BusinessViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactScreen(navController: NavController, amplifyService: AmplifyService, businessViewModel: BusinessViewModel) {

    var subject by remember { mutableStateOf(TextFieldValue("")) }
    var body by remember { mutableStateOf(TextFieldValue("")) }
    var message by remember { mutableStateOf("") }

    Scaffold(
        modifier = Constant.modifier,
        bottomBar = { CustomBottomNavigationBar(navController) },
        topBar = {
            CustomTopBar(titleText = "Contact Us", navController = navController, amplifyService = amplifyService)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = paddingValues)
                .background(color = Color(0x37000000))
                .wrapContentSize(Alignment.Center)
        ) {

            BasicTextField(
                value = subject,
                onValueChange = { subject = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color.White),
                textStyle = androidx.compose.ui.text.TextStyle.Default.copy(color = Color.Black),
                decorationBox = { innerTextField ->
                    if (subject.text.isEmpty()) {
                        Text(text = "Subject", color = Color.Gray, modifier = Modifier.padding(4.dp))
                    }
                    innerTextField()
                }
            )

            Spacer(modifier = Modifier.height(8.dp))

            BasicTextField(
                value = body,
                onValueChange = { body = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(Color.White),
                textStyle = androidx.compose.ui.text.TextStyle.Default.copy(color = Color.Black),
                decorationBox = { innerTextField ->
                    if (body.text.isEmpty()) {
                        Text(text = "Message", color = Color.Gray, modifier = Modifier.padding(4.dp))
                    }
                    innerTextField()
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                if (subject.text.isNotEmpty() && body.text.isNotEmpty()) {
                    sendEmail(subject.text, businessViewModel.email.value, body.text, onSuccess = {
                        message = "Email sent successfully!"
                    }, onFailure = {
                        message = "Failed to send email."
                    })
                } else {
                    message = "Please fill in all fields."
                }
            },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(text = "Submit")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = message,
                color = if (message == "Email sent successfully!") Color.Green else Color.Red,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center,
                fontSize = 16.sp
            )
        }
    }
}

fun sendEmail(subject: String, email: String, body: String, onSuccess: () -> Unit, onFailure: () -> Unit) {
    val request = EmailRequest(subject, email, body)
    EmailProvider.apiService.sendEmail(request).enqueue(object : Callback<Void> {
        override fun onResponse(call: Call<Void>, response: Response<Void>) {
            if (response.isSuccessful) {
                onSuccess()
            } else {
                onFailure()
            }
        }

        override fun onFailure(call: Call<Void>, t: Throwable) {
            onFailure()
        }
    })
}
