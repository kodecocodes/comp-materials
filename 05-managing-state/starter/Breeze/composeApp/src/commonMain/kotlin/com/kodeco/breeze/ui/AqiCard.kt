package com.kodeco.breeze.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.kodeco.breeze.model.AqiLevel
import com.kodeco.breeze.model.City
import com.kodeco.breeze.model.aqiLevelFrom
import com.kodeco.breeze.model.containerColor

@Composable
fun AqiCard(
  city: City,
  onClick: () -> Unit,
  modifier: Modifier = Modifier
) {

  val level = aqiLevelFrom(city.aqi)
  val onBackground = Color.White

  val containerColor = level.containerColor()
  val contentColor = contentColorFor(containerColor)

  Card(
    onClick = onClick,
    modifier = modifier
      .fillMaxWidth()
      .aspectRatio(1.4f),
    shape = RoundedCornerShape(16.dp),
    colors = CardDefaults.cardColors(
      containerColor = containerColor,
      contentColor = contentColor
    )
  ) {

    Column(
      modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
      verticalArrangement = Arrangement.SpaceBetween
    ) {

      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {

        Column {

          Text(
            text = city.name,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = onBackground
          )

          Text(
            text = city.country,
            style = MaterialTheme.typography.bodySmall,
            color = onBackground.copy(alpha = 0.8f)
          )
        }

        FlagPlaceholder(countryCode = city.countryCode)
      }

      Column {

        Text(
          text = city.aqi.toString(),
          style = MaterialTheme.typography.displaySmall,
          fontWeight = FontWeight.Black,
          color = onBackground
        )

        AqiBadge(level = level)

        Spacer(Modifier.height(4.dp))

        Text(
          text = "Updated ${city.lastUpdated}",
          style = MaterialTheme.typography.labelSmall,
          color = onBackground.copy(alpha = 0.7f)
        )
      }
    }
  }
}

@Composable
private fun FlagPlaceholder(
  countryCode: String,
  modifier: Modifier = Modifier
) {
  Box(
    modifier = modifier.run {
      size(40.dp)
        .clip(CircleShape)
        .background(Color.White.copy(alpha = 0.25f))
    },
    contentAlignment = Alignment.Center
  ) {
    Text(
      text = countryCode.uppercase(),
      style = MaterialTheme.typography.labelSmall,
      fontWeight = FontWeight.Bold,
      color = Color.White
    )
  }
}

@Composable
private fun AqiBadge(
  level: AqiLevel,
  modifier: Modifier = Modifier
) {
  Box(
    modifier = modifier
      .clip(RoundedCornerShape(50))
      .background(Color.White.copy(alpha = 0.20f))
      .padding(horizontal = 8.dp, vertical = 4.dp)
  ) {
    Text(
      text = level.label,
      style = MaterialTheme.typography.labelSmall,
      fontWeight = FontWeight.SemiBold,
      color = Color.White
    )
  }
}