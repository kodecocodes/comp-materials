package com.kodeco.breeze.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun BreezeTheme(
  darkTheme: Boolean = false,
  content:  @Composable () -> Unit,
) {
  val colorScheme = if (darkTheme) DarkColors else LightColors

  MaterialTheme(
    colorScheme = colorScheme,
    typography = BreezeTypography,
    content = content
  )
}