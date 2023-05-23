package com.jardinez.commerceapp.presentation.screens.home.home.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
    BottomNavigation(
      contentColor = MaterialTheme.colors.primary,
      backgroundColor = Color.White,
      elevation = 0.dp,
      modifier = Modifier.shadow(elevation = 0.dp)
    ) {
      screens.forEach { screen ->
        BottomNavigationItem(
          screen = screen,
          currentDestination = currentDestination,
          navController = navController
        )
      }
    }
  }

}