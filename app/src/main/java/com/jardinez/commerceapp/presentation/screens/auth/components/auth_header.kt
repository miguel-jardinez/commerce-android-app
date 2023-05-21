package com.jardinez.commerceapp.presentation.screens.auth.components

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.jardinez.commerceapp.presentation.components.DefaultSpacer
import com.jardinez.commerceapp.presentation.navigation.screen.auth.AuthScreen

@Composable
fun AuthHeader(
  navController: NavHostController,
  title: String,
  subtitle: String,
  description: String,
  actionLabel: String,
  route: AuthScreen
) {
  Box(modifier = Modifier.padding(top = 70.dp)) {
    Column {
      Text(
        text = title,
        fontSize = 26.sp,
        fontWeight = FontWeight.SemiBold
      )
      DefaultSpacer(size = 8)
      Text(
        text = subtitle,
        fontSize = 21.sp,
      )
      Spacer(modifier = Modifier.size(26.dp))
      Column {
        Text(text = description)
        DefaultSpacer(size = 8)
        Row {
          Text(text = "You can")
          DefaultSpacer(size = 8)
          Text(
            modifier = Modifier.clickable {
              navController.navigate(route.route)
            },
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.SemiBold,
            text = actionLabel
          )
        }
      }
    }
  }

}