package com.kodeco.breeze.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import breeze.composeapp.generated.resources.Res
import breeze.composeapp.generated.resources.dmsans_bold
import breeze.composeapp.generated.resources.dmsans_regular
import org.jetbrains.compose.resources.Font

val DMSansFontFamily: FontFamily
  @Composable
  get() = FontFamily(
    Font(Res.font.dmsans_regular,  weight = FontWeight.Normal),
    Font(Res.font.dmsans_bold, weight = FontWeight.Bold)
  )

val BreezeTypography: Typography
  @Composable
  get() {
    return Typography(
      headlineMedium = TextStyle(
        fontFamily = DMSansFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 28.sp,
      ),
      titleLarge = TextStyle(
        fontFamily = DMSansFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 22.sp,
      ),
      titleMedium = TextStyle(
        fontFamily = DMSansFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 16.sp,
      ),
      bodyLarge = TextStyle(
        fontFamily = DMSansFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
      ),
      bodyMedium = TextStyle(
        fontFamily = DMSansFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
      ),
      labelSmall = TextStyle(
        fontFamily = DMSansFontFamily,
        fontWeight = FontWeight.SemiBold,
        fontSize = 11.sp,
      )
    )
  }