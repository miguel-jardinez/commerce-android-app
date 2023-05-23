package com.jardinez.commerceapp.presentation.screens.home.root

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jardinez.commerceapp.presentation.navigation.graph.home.HomeNavigation
import com.jardinez.commerceapp.presentation.screens.home.home.components.HomeBottomNavigation

@Composable
fun RootScreen(navHostController: NavHostController = rememberNavController()) {

  Scaffold(
    bottomBar = {
      HomeBottomNavigation(navHostController)
    }
  ) {
    Box(modifier = Modifier.padding(it)) {
      HomeNavigation(navHostController)
    }
  }
}