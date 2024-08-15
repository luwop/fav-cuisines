package edu.uchicago.gerber.favs

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import edu.uchicago.gerber.favs.ui.theme.CusineTheme
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import edu.uchicago.gerber.favs.presentation.navigation.Navigation
import androidx.compose.animation.ExperimentalAnimationApi
import edu.uchicago.gerber.favs.authorization.AmplifyService

@OptIn(ExperimentalAnimationApi::class)
class MainActivity : ComponentActivity() {
    private val amplifyService: AmplifyService = AmplifyService()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Configure Amplify with error handling
        configureAmplify()

        setContent {
            CusineTheme {
                val navController = rememberAnimatedNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Navigation(navController = navController, amplifyService = amplifyService)
                }
            }
        }
    }

    private fun configureAmplify() {
        try {
            amplifyService.configureAmplify(this)
            Log.i("MainActivity", "Amplify successfully configured")
        } catch (e: Exception) {
            Log.e("MainActivity", "Amplify configuration failed", e)
        }
    }
}
