package com.jardinez.commerceapp.presentation.navigation.graph.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.jardinez.commerceapp.presentation.navigation.Graph
import com.jardinez.commerceapp.presentation.navigation.screen.home.HomeScreen
import com.jardinez.commerceapp.presentation.screens.home.cart.CartScreen
import com.jardinez.commerceapp.presentation.screens.home.home.HomeScreen
import com.jardinez.commerceapp.presentation.screens.home.profile.ProfileScreen
import com.jardinez.commerceapp.presentation.screens.home.settings.SettingsScreen

@Composable
fun HomeNavigation(navController: NavHostController) {
  NavHost(navController = navController, route = Graph.HOME, startDestination = HomeScreen.Home.route ) { 
    composable(route = HomeScreen.Home.route) {
      HomeScreen(navHostController = navController)
    }
    
    composable(route = HomeScreen.Profile.route) {
      ProfileScreen(navHostController = navController)
    }

    composable(route = HomeScreen.Cart.route) {
      CartScreen(navHostController = navController)
    }

    composable(route = HomeScreen.Settings.route) {
      SettingsScreen(navHostController = navController)
    }
  }
}