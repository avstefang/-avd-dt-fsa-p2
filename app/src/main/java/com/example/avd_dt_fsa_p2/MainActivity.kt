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

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Avddtfsap2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        CarDetailScreen(
                            car = Car(
                                make = "Tesla",
                                model = "Model X",
                                year = 2020,
                                category = "Sedan",
                                seats = 5,
                                rangeKm = 450,
                                licensePlate = "ABC-1234",
                                status = "AVAILABLE",
                                locationName = "Breda",
                                ownerUsername = "johndoe",
                                photoPath = null,
                                totalYearlyKilometers = 20000L,
                                tco = 5200.0,
                                beginAvailable = "2025-01-01 09:00",
                                endAvailable = "2025-12-31 18:00",
                                rentalCostPerDay = 45.0
                            )
                        )
                    }
                }
            }
        }
    }
}
