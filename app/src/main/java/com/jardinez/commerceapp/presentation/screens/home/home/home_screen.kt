package com.jardinez.commerceapp.presentation.screens.home.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.jardinez.commerceapp.presentation.navigation.graph.home.ClientNavGraph

@Composable
fun HomeScreen(navHostController: NavHostController) {
  ClientNavGraph(navHostController)
}