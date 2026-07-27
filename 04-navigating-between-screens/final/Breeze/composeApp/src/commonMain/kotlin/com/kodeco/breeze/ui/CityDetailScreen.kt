package com.kodeco.breeze.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kodeco.breeze.model.City
import com.kodeco.breeze.model.aqiLevelFrom
import com.kodeco.breeze.model.containerColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityDetailScreen(
  city: City,
  onBack: () -> Unit,
  modifier: Modifier = Modifier
) {
  Scaffold(
    modifier = modifier,
    topBar = {
      TopAppBar(
        title = { Text(city.name) },
        navigationIcon = {
          IconButton(onClick = onBack) {
            Icon(
              imageVector = Icons.AutoMirrored.Filled.ArrowBack,
              contentDescription = "Return to previous screen"
            )
          }
        }
      )
    },
  ) { padding ->
    val level = aqiLevelFrom(city.aqi)

    Column(
      modifier = modifier
        .fillMaxSize()
        .padding(padding),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
    ) {
      Text(
        text = city.name,
        style = MaterialTheme.typography.headlineMedium
      )

      Text(
        text = city.country,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant
      )

      Spacer(Modifier.height(32.dp))

      Text(
        text = city.aqi.toString(),
        style = MaterialTheme.typography.displayLarge,
        fontWeight = FontWeight.Bold,
        color = level.containerColor()
      )

      Text(
        text = level.label,
        style = MaterialTheme.typography.titleLarge,
        color = level.containerColor()
      )
    }
  }
}