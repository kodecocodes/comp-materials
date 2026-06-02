package com.kodeco.breeze

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kodeco.breeze.model.stubCities
import com.kodeco.breeze.ui.CityList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    MaterialTheme {
        Scaffold(
            topBar = {
                TopAppBar(title = { Text("Breeze") })
            }
        ) { padding ->
            CityList(
                cities = stubCities,
                modifier = Modifier.padding(padding)
            )
        }
    }
}