package com.example.avd_dt_fsa_p2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.avd_dt_fsa_p2.ui.theme.Avddtfsap2Theme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            Avddtfsap2Theme {
                CreateVehicleScreen(
                    onBack = { finish() },
                    onSave = { vehicleInput ->
//                        println(vehicleInput)
                    }
                )
            }
        }
    }
}

