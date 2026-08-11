package com.kodeco.breeze.viewmodel

import com.kodeco.breeze.model.City

data class CityListUiState(
  val cities: List<City> = emptyList(),
  val favoriteIds: Set<String> = emptySet(),
)