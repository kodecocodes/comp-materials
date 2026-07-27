package com.kodeco.breeze.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kodeco.breeze.model.City
import com.kodeco.breeze.model.stubCities

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityListScreen(
  onCityClick: (City) -> Unit,
  darkTheme: Boolean,
  onToggleTheme: () -> Unit,
  modifier: Modifier = Modifier,
) {
  Scaffold(
    modifier = modifier,
    topBar = {
      TopAppBar(
        title = { Text("Breeze") },
        actions = {
          IconButton(onClick = { onToggleTheme() }) {
            Icon(
              imageVector = if (darkTheme)
                Icons.Default.LightMode
              else
                Icons.Default.DarkMode,
              contentDescription = if (darkTheme)
                "Switch to light mode"
              else
                "Switch to dark mode"
            )
          }
        }
      )
    }
  ) { padding ->
    CityList(
      cities = stubCities,
      onCityClick = onCityClick,
      modifier = Modifier.padding(padding),
    )
  }
}