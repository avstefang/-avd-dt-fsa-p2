package com.example.avd_dt_fsa_p2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.avd_dt_fsa_p2.ui.theme.Avddtfsap2Theme
import com.example.avd_dt_fsa_p2.view.Footer

class MainActivity : ComponentActivity() {
    // Add footer to app
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Avddtfsap2Theme {
                // A surface container using the 'background' color from the theme
                Scaffold(
                    bottomBar = {
                        Footer(
                            actionHome = { /* TODO */ },
                            actionSearch = { /* TODO */ },
                            actionAccount = { /* TODO */ }
                        )
                    }
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        // Main content goes here
                    }
                }
            }
        }
    }
}
