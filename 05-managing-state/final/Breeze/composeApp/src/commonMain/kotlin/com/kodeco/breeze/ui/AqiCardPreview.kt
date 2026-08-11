package com.kodeco.breeze.ui

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kodeco.breeze.model.City

@Preview
@Composable
fun AqiCardAllLevelsPreview() {
  val previewCities = listOf(
    City("p1", "Coimbra", "Portugal", "pt", "just now", aqi = 150),
    City("p2", "London", "United Kingdom", "gb", "just now", aqi = 75),
    City("p3", "São Paulo", "Brazil", "br", "just now", aqi = 132),
    City("p4", "Los Angeles", "United States", "us", "1 min ago",  aqi = 187),
    City("p5", "Beijing", "China", "cn", "just now", aqi = 245),
    City("p6", "New Delhi", "India", "in", "just now", aqi = 380)
  )

  Column(
    modifier = Modifier.padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(8.dp)
  ) {
    previewCities.forEach { city ->
      AqiCard(
        city = city,
        onClick = {},
        isFavorite = false,
        onToggleFavorite = {}
      )
    }
  }
}