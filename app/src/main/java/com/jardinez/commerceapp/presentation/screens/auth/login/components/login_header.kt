package com.jardinez.commerceapp.presentation.screens.auth.login.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.jardinez.commerceapp.presentation.components.DefaultSpacer
import com.jardinez.commerceapp.presentation.navigation.screen.auth.AuthScreen

@Composable
fun LoginHeader(navController: NavHostController) {
  Box(modifier = Modifier.padding(top = 70.dp)) {
    Column {
      Text(
        text = "Login in",
        fontSize = 26.sp,
        fontWeight = FontWeight.SemiBold
      )
      DefaultSpacer(size = 8)
      Text(
        text = "Glad to see you here again!",
        fontSize = 21.sp,
      )
      Spacer(modifier = Modifier.size(26.dp))
      Column {
        Text(text = "If you don’t have an account register")
        DefaultSpacer(size = 8)
        Row {
          Text(text = "You can")
          DefaultSpacer(size = 8)
          Text(
            modifier = Modifier.clickable { 
              navController.navigate(AuthScreen.Register.route)
            },
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.SemiBold,
            text = "Register here !"
          )
        }
      }
    }
  }
}

@Preview(showSystemUi = true)
@Composable
fun LoginHeaderPreview() {
  Box {
    LoginHeader(navController = rememberNavController())
  } 
}