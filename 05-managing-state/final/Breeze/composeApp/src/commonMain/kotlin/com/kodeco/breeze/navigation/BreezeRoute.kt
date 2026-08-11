package com.kodeco.breeze.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed interface BreezeRoute : NavKey

@Serializable
data object CityListRoute : BreezeRoute

@Serializable
data class CityDetailRoute(val cityId: String) : BreezeRoute