package com.example.avd_dt_fsa_p2

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class Car(
    val make: String,
    val model: String,
    val year: Int,
    val category: String?,
    val seats: Int,
    val rangeKm: Int?,
    val licensePlate: String,
    val status: String,
    val locationName: String?,
    val ownerUsername: String?,
    val photoPath: String?,
    val totalYearlyKilometers: Long?,
    val tco: Double?,
    val beginAvailable: String?,
    val endAvailable: String?,
    val rentalCostPerDay: Double
)

@Composable
fun HomeScreen() {
    val placeholderCars = List(10) { index ->
        Car(
            make = "Make ${index + 1}",
            model = "Model ${index + 1}",
            year = 2015 + (index % 8),
            category = "Category ${(index % 3) + 1}",
            seats = 5,
            rangeKm = 300 + index * 10,
            licensePlate = "ABC-${1000 + index}",
            status = if (index % 3 == 0) "RENTED" else "AVAILABLE",
            locationName = "Location ${(index % 4) + 1}",
            ownerUsername = "owner${index + 1}",
            photoPath = null,
            totalYearlyKilometers = 15000L + index * 500,
            tco = 4500.0 + index * 100,
            beginAvailable = "2025-01-01 09:00",
            endAvailable = "2025-12-31 18:00",
            rentalCostPerDay = 30.0 + index * 5
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 24.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Plug & Play - Car Rental App",
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "Cars of the Day",
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            // Chip-like label for quick pricing info
            Surface(
                shape = RoundedCornerShape(50),
                color = MaterialTheme.colorScheme.primary.copy(alpha = 0.08f),
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.4f))
            ) {
                Text(
                    text = "From $30/day",
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 4.dp),
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Text(
                text = "Showing ${placeholderCars.take(8).size} of ${placeholderCars.size} cars",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Spacer(modifier = Modifier.height(8.dp))

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 360.dp),
                shape = RoundedCornerShape(16.dp),
                tonalElevation = 2.dp,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.outlineVariant)
            ) {
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    LazyColumn(
                        modifier = Modifier.fillMaxWidth(),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(placeholderCars.take(8)) { car ->
                            CarItem(car = car)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CarItem(car: Car) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "${car.make} ${car.model}",
                style = MaterialTheme.typography.titleMedium
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Year: ${car.year}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "Seats: ${car.seats}",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = "Cost: $${"%.2f".format(car.rentalCostPerDay)}/day",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}
