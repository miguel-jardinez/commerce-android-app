package com.jardinez.commerceapp.presentation.navigation.graph.auth

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jardinez.commerceapp.presentation.navigation.Graph
import com.jardinez.commerceapp.presentation.navigation.screen.auth.AuthScreen
import com.jardinez.commerceapp.presentation.screens.auth.login.LoginScreen
import com.jardinez.commerceapp.presentation.screens.auth.register.RegisterScreen

fun NavGraphBuilder.AuthNavGraph(navController: NavHostController) {
  navigation(
    startDestination = AuthScreen.Login.route,
    route = Graph.AUTH
  ) {

    composable(route = AuthScreen.Login.route) {
      LoginScreen(navController = navController)
    }

    composable(route = AuthScreen.Register.route) {
      RegisterScreen(navController = navController)
    }

  }
}