package com.jardinez.commerceapp.presentation.navigation.graph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.jardinez.commerceapp.presentation.navigation.Graph
import com.jardinez.commerceapp.presentation.navigation.graph.auth.AuthNavGraph
import com.jardinez.commerceapp.presentation.navigation.graph.home.HomeNavGraph

@Composable
fun RootNavGraph(navController: NavHostController) {
  NavHost(
    navController = navController,
    route = Graph.ROOT,
    startDestination = Graph.AUTH
  ) {
    AuthNavGraph(navController = navController)
    HomeNavGraph()
  }
}