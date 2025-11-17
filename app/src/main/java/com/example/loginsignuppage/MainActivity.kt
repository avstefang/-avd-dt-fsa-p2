package com.example.loginsignuppage

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.loginsignuppage.ui.theme.LoginSignupPageTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            LoginSignupPageTheme {
                LoginScreen { email, password ->
                    println("Login clicked → $email / $password")
                }
            }
        }
    }
}