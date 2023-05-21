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
import com.jardinez.commerceapp.presentation.components.CustomSpacer

@Composable
fun LoginHeader() {
  Box(modifier = Modifier.padding(top = 70.dp)) {
    Column {
      Text(
        text = "Login in",
        fontSize = 26.sp,
        fontWeight = FontWeight.SemiBold
      )
      CustomSpacer(size = 8)
      Text(
        text = "Glad to see you here again!",
        fontSize = 21.sp,
      )
      Spacer(modifier = Modifier.size(26.dp))
      Column {
        Text(text = "If you don’t have an account register")
        CustomSpacer(size = 8)
        Row {
          Text(text = "You can")
          CustomSpacer(size = 8)
          Text(
            modifier = Modifier.clickable {  },
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
    LoginHeader()
  } 
}