package com.kodeco.breeze

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.kodeco.breeze.model.stubCities
import com.kodeco.breeze.navigation.CityDetailRoute
import com.kodeco.breeze.navigation.CityListRoute
import com.kodeco.breeze.navigation.breezeNavConfig
import com.kodeco.breeze.ui.CityDetailScreen
import com.kodeco.breeze.ui.CityList
import com.kodeco.breeze.ui.CityListScreen
import com.kodeco.breeze.ui.theme.BreezeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    val systemDark = isSystemInDarkTheme()
    var darkTheme by remember { mutableStateOf(systemDark) }

    BreezeTheme(darkTheme = darkTheme) {
        val backStack = rememberNavBackStack(breezeNavConfig, CityListRoute)

        NavDisplay(
            backStack = backStack,
            onBack = { backStack.removeLastOrNull() },
            entryProvider = entryProvider {
                entry<CityListRoute> {
                    CityListScreen(
                        onCityClick = { city ->
                            backStack.add(CityDetailRoute(city.id))
                        },
                        darkTheme = darkTheme,
                        onToggleTheme = { darkTheme = !darkTheme }
                    )
                }
                entry<CityDetailRoute> { route ->
                    val city = stubCities.first { it.id == route.cityId }
                    CityDetailScreen(
                        city = city,
                        onBack = { backStack.removeLastOrNull() },
                    )
                }
            },
        )
    }
}