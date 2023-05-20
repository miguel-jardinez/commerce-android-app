package com.jardinez.commerceapp.presentation.screens.auth.login.components

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jardinez.commerceapp.presentation.screens.auth.login.view_model.LoginViewModel

@Composable
fun LoginContent(navController: NavHostController, viewModel: LoginViewModel = hiltViewModel()) {
  Box {
    Text(text = "Login Screen")
  }
}