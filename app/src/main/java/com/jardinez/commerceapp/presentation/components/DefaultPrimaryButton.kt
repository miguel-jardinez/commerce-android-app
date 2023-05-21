package com.jardinez.commerceapp.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DefaultPrimaryButton(
  text: String,
  loading: Boolean = false,
  onClick: () -> Unit
) {
  Button(
    modifier = Modifier
      .fillMaxWidth()
      .height(60.dp),
    shape = RoundedCornerShape(9.dp),
    colors = ButtonDefaults.buttonColors(
      containerColor =  MaterialTheme.colors.primary
    ),
    onClick = onClick
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically
    ) {
      if (loading) {
        CircularProgressIndicator(
          modifier = Modifier.size(18.dp),
          strokeWidth = 2.dp,
          color = Color.White
        )
        CustomSpacer(size = 14)
      }
      Text(text = text, fontSize = 18.sp)
    }
  }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPrimaryButtonPreview() {
  Box {
    DefaultPrimaryButton("Login") {}
  }
}