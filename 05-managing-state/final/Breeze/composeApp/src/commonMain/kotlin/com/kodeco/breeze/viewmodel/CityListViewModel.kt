package com.kodeco.breeze.viewmodel

import androidx.lifecycle.ViewModel
import com.kodeco.breeze.model.stubCities
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class CityListViewModel : ViewModel() {
  private val _uiState = MutableStateFlow(CityListUiState())

  val uiState: StateFlow<CityListUiState> = _uiState.asStateFlow()

  init {
    _uiState.update { it.copy(cities = stubCities) }
  }

  fun toggleFavorite(cityId: String) {
    _uiState.update { state ->
      val favorites = if (cityId in state.favoriteIds) {
        state.favoriteIds - cityId
      } else {
        state.favoriteIds + cityId
      }
      state.copy(favoriteIds = favorites)
    }
  }
}