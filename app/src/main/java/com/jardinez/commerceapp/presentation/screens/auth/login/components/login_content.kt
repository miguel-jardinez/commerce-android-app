package com.jardinez.commerceapp.presentation.screens.auth.login.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun LoginContent(navController: NavHostController) {
  Box(
    modifier = Modifier.padding(horizontal = 16.dp)
  ) {
    Column {
      LoginHeader()
      LoginForm()
    }
  }
}

@Preview("Login Content", showSystemUi = true)
@Composable
fun LoginContentPreview() {
  LoginContent(navController = rememberNavController())
}