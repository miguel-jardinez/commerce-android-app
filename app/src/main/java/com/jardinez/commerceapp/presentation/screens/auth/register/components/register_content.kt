package com.jardinez.commerceapp.presentation.screens.auth.register.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jardinez.commerceapp.presentation.screens.auth.register.view_model.RegisterViewModel

@Composable
fun RegisterContent(navController: NavHostController, viewModel: RegisterViewModel = hiltViewModel()) {
  Column {
    Text(text = "Register Screen")
  }
}