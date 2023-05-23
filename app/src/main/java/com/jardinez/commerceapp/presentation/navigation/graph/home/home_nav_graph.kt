package com.jardinez.commerceapp.presentation.navigation.graph.home

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.jardinez.commerceapp.presentation.navigation.Graph
import com.jardinez.commerceapp.presentation.screens.home.root.RootScreen

fun NavGraphBuilder.HomeNavGraph() {
  navigation(route = Graph.LOGGED, startDestination = Graph.HOME) {
    composable(route = Graph.HOME) {
      RootScreen()
    }
  }
}