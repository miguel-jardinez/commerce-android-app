package com.jardinez.commerceapp.presentation.navigation.screen.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.ui.graphics.vector.ImageVector

sealed class HomeScreen(
  val route: String,
  val title: String,
  val icon: ImageVector
) {
  object Home : HomeScreen("/home/products", "Home", Icons.Default.Home)
  object Profile : HomeScreen("/home/profile", "Profile", Icons.Default.Person)
  object Cart : HomeScreen("/home/cart", "Cart", Icons.Default.ShoppingCart)
  object Settings : HomeScreen("/home/settings", "Config", Icons.Default.Settings)
}
