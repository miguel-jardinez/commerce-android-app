package com.jardinez.commerceapp.presentation.screens.home.home.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.jardinez.commerceapp.presentation.components.DefaultSpacer
import com.jardinez.commerceapp.presentation.navigation.screen.home.HomeScreen

@Composable
fun RowScope.BottomNavigationItem(
  screen: HomeScreen,
  currentDestination: NavDestination?,
  navController: NavHostController
) {
  val isSelected = currentDestination?.hierarchy?.any {
    it.route == screen.route
  } == true

  BottomNavigationItem(
    icon = {
      Row {
          Icon(
            imageVector = screen.icon,
            contentDescription = screen.title
          )
          DefaultSpacer(size = 8)
          AnimatedVisibility(isSelected) {
            Text(screen.title, color = MaterialTheme.colors.primary)
          }

        }
    },
    unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
    selected = isSelected,
    onClick = {
      navController.navigate(route = screen.route) {
        popUpTo(navController.graph.findStartDestination().id)
      }
    }
  )
}