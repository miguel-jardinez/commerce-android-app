package com.jardinez.commerceapp.presentation.screens.auth.login.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jardinez.commerceapp.presentation.navigation.Graph
import com.jardinez.commerceapp.presentation.screens.auth.login.events.UIEvents
import com.jardinez.commerceapp.presentation.screens.auth.login.view_model.LoginViewModel
import kotlinx.coroutines.flow.collectLatest

@Composable
fun Login(
  navController: NavHostController,
  viewModel: LoginViewModel = hiltViewModel()
) {
  LaunchedEffect(Unit) {
    viewModel.uiEvents.collectLatest { event ->
      when(event) {
        UIEvents.NavigateToLogin -> {
          navController.navigate(route = Graph.LOGGED) {
            popUpTo(Graph.AUTH) {
              inclusive = true
            }
          }
        }
      }
    }
  }
}