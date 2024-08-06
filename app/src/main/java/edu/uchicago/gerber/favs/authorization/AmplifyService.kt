package edu.uchicago.gerber.favs.authorization

import android.content.Context
import android.util.Log
import com.amplifyframework.auth.AuthException
import com.amplifyframework.auth.AuthUserAttribute
import com.amplifyframework.auth.AuthUserAttributeKey
import com.amplifyframework.auth.cognito.AWSCognitoAuthPlugin
import com.amplifyframework.auth.options.AuthSignUpOptions
import com.amplifyframework.core.Amplify



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
    fun fetchEmailAndLog() {
        Amplify.Auth.fetchUserAttributes(
            { attributes: List<AuthUserAttribute> ->
                // Use the firstOrNull function to get the email attribute
                val emailAttribute = attributes.firstOrNull { it.key == AuthUserAttributeKey.email() }
                if (emailAttribute != null) {
                    val email = emailAttribute.value
                    Log.i("ampy", "Email: $email")

                } else {
                    Log.i("ampy", "Email attribute not found")

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
            { Log.e("ampy", "Sign Up Error:", it) }
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