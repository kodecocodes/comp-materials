package com.kodeco.breeze.viewmodel

import androidx.lifecycle.ViewModel
import com.kodeco.breeze.model.City
import com.kodeco.breeze.model.stubCities
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CityDetailViewModel(cityId: String) : ViewModel() {
  private val _city = MutableStateFlow<City?>(null)
  val city: StateFlow<City?> = _city.asStateFlow()

  init {
    _city.value = stubCities.firstOrNull { it.id == cityId }
  }
}