package com.kodeco.breeze.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import breeze.composeapp.generated.resources.Res
import breeze.composeapp.generated.resources.city_not_found
import com.kodeco.breeze.model.City
import com.kodeco.breeze.model.aqiLevelFrom
import com.kodeco.breeze.model.containerColor
import com.kodeco.breeze.viewmodel.CityDetailViewModel
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CityDetailScreen(
  cityId: String,
  onBack: () -> Unit,
  modifier: Modifier = Modifier,
  viewModel: CityDetailViewModel = viewModel { CityDetailViewModel(cityId) }
) {
  val city by viewModel.city.collectAsState()

  Scaffold(
    modifier = modifier,
    topBar = {
      TopAppBar(
        title = { Text(city?.name ?: cityId) },
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
    val current = city
    if (current == null) {
      Box(Modifier.fillMaxSize().padding(padding), Alignment.Center) {
        Text(stringResource(Res.string.city_not_found))
      }
      return@Scaffold
    }

    val level = aqiLevelFrom(current.aqi)

    Column(
      modifier = modifier
        .fillMaxSize()
        .padding(padding),
      horizontalAlignment = Alignment.CenterHorizontally,
      verticalArrangement = Arrangement.Center
    ) {
      Text(
        text = current.name,
        style = MaterialTheme.typography.headlineMedium
      )

      Text(
        text = current.country,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.onSurfaceVariant
      )

      Spacer(Modifier.height(32.dp))

      Text(
        text = current.aqi.toString(),
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