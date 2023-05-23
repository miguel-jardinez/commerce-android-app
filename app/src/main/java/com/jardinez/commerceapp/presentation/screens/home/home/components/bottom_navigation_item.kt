package com.jardinez.commerceapp.presentation.screens.home.home.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.jardinez.commerceapp.presentation.navigation.screen.home.HomeScreen

@Composable
fun RowScope.BottomNaviagtionItem(
  screen: HomeScreen,
  currentDestination: NavDestination?,
  navController: NavHostController
) {
  val isSelected = currentDestination?.hierarchy?.any {
    it.route == screen.route
  } == true

  val colorSelected = if (!isSelected)  Color.White.copy(alpha = 0.5f) else Color.White

  BottomNavigationItem(
    label = {
      Text(
        text = screen.title,
        color = colorSelected
      )
    },
    icon = {
      Icon(imageVector = screen.icon, contentDescription = "")
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