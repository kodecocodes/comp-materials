package com.kodeco.breeze.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

sealed class AqiLevel(
  val label: String,
  val range: IntRange
) {
  object Good : AqiLevel("Good", 0..50)
  object Moderate : AqiLevel("Moderate", 51..100)
  object UnhealthySensitive : AqiLevel("Unhealthy for Sensitive", 101..150)
  object Unhealthy : AqiLevel("Unhealthy", 151..200)
  object VeryUnhealthy : AqiLevel("Very Unhealthy", 201..300)
  object Hazardous : AqiLevel("Hazardous", 301..500)
}

fun aqiLevelFrom(value: Int): AqiLevel = when {
  value <= 50  -> AqiLevel.Good
  value <= 100 -> AqiLevel.Moderate
  value <= 150 -> AqiLevel.UnhealthySensitive
  value <= 200 -> AqiLevel.Unhealthy
  value <= 300 -> AqiLevel.VeryUnhealthy
  else -> AqiLevel.Hazardous
}

@Composable
fun AqiLevel.containerColor(): Color = when (this) {
  is AqiLevel.Good -> Color(0xFF1D9E75)
  is AqiLevel.Moderate -> Color(0xFFF2A623)
  is AqiLevel.UnhealthySensitive -> Color(0xFFD85A30)
  is AqiLevel.Unhealthy -> Color(0xFFA32D2D)
  is AqiLevel.VeryUnhealthy -> Color(0xFF534AB7)
  is AqiLevel.Hazardous -> Color(0xFF26215C)
}





















