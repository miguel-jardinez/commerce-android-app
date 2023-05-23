package com.jardinez.commerceapp.presentation.screens.home.home.components

import androidx.compose.material.BottomNavigation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.jardinez.commerceapp.presentation.navigation.screen.home.HomeScreen

@Composable
fun HomeBottomNavigation(navController: NavHostController) {

  val screens = listOf(
    HomeScreen.Home,
    HomeScreen.Profile,
    HomeScreen.Cart,
    HomeScreen.Settings
  )

  val navBackEntry by navController.currentBackStackEntryAsState()
  val currentDestination = navBackEntry?.destination
  val bottomBarDestination = screens.any { it.route == currentDestination?.route }

  if (bottomBarDestination) {
    BottomNavigation {
      screens.forEach { screen ->
        BottomNaviagtionItem(
          screen = screen,
          currentDestination = currentDestination,
          navController = navController
        )
      }
    }
  }

}