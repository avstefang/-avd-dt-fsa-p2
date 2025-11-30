package com.example.avd_dt_fsa_p2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CameraAlt

data class VehicleInput(
    val make: String,
    val model: String,
    val year: Int?,
    val category: String,
    val seats: Int?,
    val rangeKm: Int?,
    val licensePlate: String
)

@Composable
fun CreateVehicleScreen(
    onBack: () -> Unit,
    onSave: (VehicleInput) -> Unit
) {
    var make by remember { mutableStateOf("") }
    var model by remember { mutableStateOf("") }
    var year by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var seats by remember { mutableStateOf("") }
    var rangeKm by remember { mutableStateOf("") }
    var licensePlate by remember { mutableStateOf("") }

    val buttonGreen = Color(0xFF458C3E)

    val isValid =
        make.isNotBlank() &&
                model.isNotBlank() &&
                year.isNotBlank() &&
                seats.isNotBlank() &&
                licensePlate.isNotBlank()

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = onBack) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back"
                    )
                }
                Text(
                    text = "Add Vehicle",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    ) { inner ->

        Column(
            modifier = Modifier
                .padding(inner)
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp)
                    .background(Color(0xFFF0F0F0), RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(
                        imageVector = Icons.Filled.CameraAlt,
                        contentDescription = null,
                        tint = Color.Gray,
                        modifier = Modifier.size(36.dp)
                    )
                    Text(
                        text = "Upload vehicle photo",
                        color = Color.Gray,
                        fontSize = 12.sp
                    )
                }
            }

            FilledField("Make", make) { make = it }
            FilledField("Model", model) { model = it }
            FilledField("Year", year) { year = it }
            FilledField("Category", category) { category = it }
            FilledField("Seats", seats) { seats = it }
            FilledField("Range (km)", rangeKm) { rangeKm = it }
            FilledField("License Plate", licensePlate) { licensePlate = it }

            Spacer(Modifier.height(12.dp))

            Button(
                onClick = {
                    onSave(
                        VehicleInput(
                            make = make,
                            model = model,
                            year = year.toIntOrNull(),
                            category = category,
                            seats = seats.toIntOrNull(),
                            rangeKm = rangeKm.toIntOrNull(),
                            licensePlate = licensePlate
                        )
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp),
                shape = RoundedCornerShape(50),
                enabled = isValid,
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = if (isValid) 6.dp else 0.dp,
                    pressedElevation = 2.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonGreen,
                    disabledContainerColor = Color(0xFFBDBDBD),
                    contentColor = Color.White
                )
            ) {
                Text("Create Vehicle")
            }

            Spacer(Modifier.height(32.dp))
        }
    }
}

@Composable
fun FilledField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(label) },
        singleLine = true,
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            unfocusedContainerColor = Color(0xFFF3F3F3),
            focusedContainerColor = Color(0xFFF3F3F3),
            unfocusedBorderColor = Color.Transparent,
            focusedBorderColor = Color.Transparent
        )
    )
}
