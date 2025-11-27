package com.example.avd_dt_fsa_p2.view

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.times

@Composable
fun Footer(actionHome: () -> Unit, actionSearch: () -> Unit, actionAccount: () -> Unit, selectedTab: Int = 0/*modifier: Modifier*/) {
    val shape = MaterialTheme.shapes.extraLarge
    var selectedTab by rememberSaveable { mutableStateOf(selectedTab) }
    val configuration = LocalConfiguration.current
    val screenHeight = configuration.screenHeightDp.dp
    val screenWidth = configuration.screenWidthDp.dp

    var variableHeight: Dp
    var variableWidth: Dp
    if (Configuration.ORIENTATION_LANDSCAPE == configuration.orientation) {
        variableHeight = (screenHeight * 0.2f)
        variableWidth = (screenWidth * 0.2f)

    } else {
        variableHeight = (screenHeight * 0.08f)
        variableWidth = (screenWidth * 0.28f)
    }

    val setHeight = variableHeight.coerceAtLeast(48.dp)
    val setPadding = (screenWidth * 0.02f).coerceIn(8.dp, 16.dp)
    val buttonWidth = variableWidth.coerceAtLeast(48.dp)

    Box(
        contentAlignment = Alignment.BottomCenter
    ) {

        LazyRow(
            modifier = Modifier
                .height(setHeight)
                .background(MaterialTheme.colorScheme.onBackground)
                .fillMaxSize()
                .padding(0.dp, setPadding),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Home button
            item {
                Button(
                    onClick = {
                        selectedTab = 0
                        actionHome.invoke()
                    },
                    colors = if (selectedTab == 0)
                        ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onSurface)
                    else
                        ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                    shape = shape,
                    modifier = Modifier.width(buttonWidth)
                        .fillMaxHeight()
                ) {
                    Icon(Icons.Filled.Home,"Home")
                }
            }
            // Search button
            item {
                Button(
                    onClick = {
                        selectedTab = 1
                        actionSearch.invoke()
                    },
                    colors = if (selectedTab == 1)
                        ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onSurface)
                    else
                        ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                    shape = shape,
                    modifier = Modifier.width(buttonWidth)
                        .fillMaxHeight()
                ) {
                    Icon(Icons.Filled.Search, "Search")
                }
            }
            // Account button
            item {
                Button(
                    onClick = {
                        selectedTab = 2
                        actionAccount.invoke()
                    },
                    colors = if (selectedTab == 2)
                        ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onSurface)
                    else
                        ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                    shape = shape,
                    modifier = Modifier.width(buttonWidth)
                        .fillMaxHeight()
                ) {
                    Icon(Icons.Filled.AccountCircle, "Account")
                }
            }
        }

    }
}