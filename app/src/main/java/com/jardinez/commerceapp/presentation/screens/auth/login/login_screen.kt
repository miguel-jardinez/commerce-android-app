package com.jardinez.commerceapp.presentation.screens.auth.login

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.jardinez.commerceapp.presentation.screens.auth.login.components.LoginContent

@Composable
fun LoginScreen(navController: NavHostController) {
  Scaffold {paddingValues ->
    Box(modifier = Modifier.padding(paddingValues)) {
      LoginContent(navController)
    }
  }
}