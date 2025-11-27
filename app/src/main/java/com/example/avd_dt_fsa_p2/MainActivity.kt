package com.example.avd_dt_fsa_p2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.avd_dt_fsa_p2.ui.theme.Avddtfsap2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        enableEdgeToEdge()
        setContent {
            Avddtfsap2Theme {
                Box{
                    Text("")
                }
            }
        }
    }
}

