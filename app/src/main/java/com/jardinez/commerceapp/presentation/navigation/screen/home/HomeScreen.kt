package com.jardinez.commerceapp.presentation.navigation.screen.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class HomeScreen(
  val route: String,
  val title: String,
  val icon: ImageVector
) {
  object Home : HomeScreen("/home/products", "Home", Icons.Outlined.Home)
  object Profile : HomeScreen("/home/profile", "Profile", Icons.Outlined.Person)
  object Cart : HomeScreen("/home/cart", "Cart", Icons.Outlined.ShoppingCart)
  object Settings : HomeScreen("/home/settings", "Config", Icons.Outlined.Menu)
}
