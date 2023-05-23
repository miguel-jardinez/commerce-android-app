package com.jardinez.commerceapp.presentation.screens.auth.register.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jardinez.commerceapp.presentation.navigation.screen.auth.AuthScreen
import com.jardinez.commerceapp.presentation.screens.auth.components.AuthHeader

@Composable
fun RegisterContent(navController: NavHostController) {
  Box(modifier = Modifier.padding(horizontal = 16.dp)) {
    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
      AuthHeader(
        navController = navController,
        title = "Sign Up",
        subtitle = "Glad to see you here!",
        description = "If you already have an account register",
        actionLabel = "Login here !",
        route = AuthScreen.Login
      )

      RegisterForm()
    }
  }
}

@Preview(showSystemUi = true)
@Composable
fun RegisterContentPreview() {
  RegisterContent(rememberNavController())
}