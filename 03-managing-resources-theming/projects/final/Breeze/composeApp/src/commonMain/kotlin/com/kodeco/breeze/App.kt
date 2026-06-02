package com.kodeco.breeze

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.kodeco.breeze.model.stubCities
import com.kodeco.breeze.ui.CityList
import com.kodeco.breeze.ui.theme.BreezeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    val systemDark = isSystemInDarkTheme()
    var darkTheme by remember { mutableStateOf(systemDark) }

    BreezeTheme(darkTheme = darkTheme) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Breeze") },
                    actions = {
                        IconButton(onClick = { darkTheme = !darkTheme }) {
                            Icon(
                                imageVector = if (darkTheme)
                                    Icons.Default.LightMode
                                else
                                    Icons.Default.DarkMode,
                                contentDescription = if (darkTheme)
                                    "Switch to light mode"
                                else
                                    "Switch to dark mode",
                            )
                        }
                    }
                )
            }
        ) { padding ->
            CityList(
                cities = stubCities,
                modifier = Modifier.padding(padding)
            )
        }
    }
}