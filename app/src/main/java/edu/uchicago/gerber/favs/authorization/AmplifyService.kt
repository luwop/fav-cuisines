package edu.uchicago.gerber.favs.authorization

import android.content.Context
import android.util.Log
import com.amplifyframework.auth.AuthException
import com.amplifyframework.auth.AuthUserAttribute
import com.amplifyframework.auth.AuthUserAttributeKey
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin
import com.amplifyframework.auth.options.AuthSignUpOptions
import com.amplifyframework.core.Amplify
import edu.uchicago.gerber.favs.presentation.viewmodels.BusinessViewModel


class AmplifyService  {

     fun configureAmplify(context: Context) {
        try {
            Amplify.addPlugin(AWSCognitoAuthPlugin())
            Amplify.configure(context)
            Log.i("ampy", "Configured amplify")
        } catch (e: Exception) {
            Log.e("ampy", "Amplify configuration failed", e)
        }
    }
    //this method fetches the sessionEmail. This is the email associated with the current user's authenticated
    //session. This value may be different from the 'email' prop which is part of the auth-flow and already defined in ViewModel.
    fun fetchEmailAndLog(viewModel: BusinessViewModel) {
        Amplify.Auth.fetchUserAttributes(
            { attributes: List<AuthUserAttribute> ->
                // Use the firstOrNull function to get the session email attribute
                val emailAttribute = attributes.firstOrNull { it.key == AuthUserAttributeKey.email() }
                if (emailAttribute != null) {
                    val sessionEmail = emailAttribute.value
                    viewModel.setEmail(sessionEmail)
                    Log.i("ampy", "Session Email: $sessionEmail")

                } else {
                    Log.i("ampy", "Session Email attribute not found")

                }
            },
            { error: AuthException ->
                Log.e("ampy", "Failed to fetch user attributes.", error)
            }
        )
    }

     fun signUp(username: String, email: String, password: String, onComplete: () -> Unit) {
        val options = AuthSignUpOptions.builder()
            .userAttribute(AuthUserAttributeKey.email(), email)
            .build()

         Amplify.Auth.signUp(username, password, options,
             { onComplete() },
             { exception ->
                 Log.e("ampy", "Sign Up Error: ${exception.localizedMessage}", exception)
             }
         )
    }

     fun verifyCode(username: String, code: String, onComplete: () -> Unit) {
        Amplify.Auth.confirmSignUp(
            username,
            code,
            { onComplete() },
            { Log.e("ampy", "Verification Failed: ", it) }
        )
    }

     fun login(username: String, password: String, onComplete: () -> Unit) {
        Amplify.Auth.signIn(
            username,
            password,
            { onComplete() },
            { Log.e("ampy", "Login Error:", it) }
        )
    }

     fun logOut(onComplete: () -> Unit) {
        Amplify.Auth.signOut(
            { onComplete() },
            { Log.e("ampy", "Sign Out Failed: ", it) }
        )
    }
}