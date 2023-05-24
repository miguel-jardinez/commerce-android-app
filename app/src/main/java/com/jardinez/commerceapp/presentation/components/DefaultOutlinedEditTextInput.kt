package com.jardinez.commerceapp.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DefaultOutlinedEditTextInput(
  value: String,
  hint: String,
  trailingIcon: ImageVector? = null,
  onClickTrailingIcon: () -> Unit = {},
  iconDescriptionTrailing: String? = "",
  isError: Boolean,
  errorMessage: String? = "",
  isPassword: Boolean,
  keyboardType: KeyboardType,
  onValueChange: (text: String) -> Unit
) {
  Column(
    modifier = Modifier.padding(top = 16.dp)
  ) {
    OutlinedTextField(
      modifier = Modifier
        .fillMaxWidth(),
      trailingIcon = {
        if (trailingIcon != null) {
          IconButton(
            onClick = onClickTrailingIcon
          ) {
            Icon(imageVector = trailingIcon,
              contentDescription = iconDescriptionTrailing)
          }
        }
      },

      isError = isError,
      visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
      keyboardOptions = KeyboardOptions(
        keyboardType = keyboardType,
        autoCorrect = true
      ),
      placeholder = {
        Text(text = hint)
      },
      value = value,
      colors = TextFieldDefaults.outlinedTextFieldColors(
        backgroundColor = Color(color = 0XFFF0EFFF),
        placeholderColor = MaterialTheme.colors.primary.copy(alpha = 0.5f),
        unfocusedBorderColor = Color.Transparent,
        focusedBorderColor = Color.Transparent,
        textColor = MaterialTheme.colors.primary,
        unfocusedLabelColor = MaterialTheme.colors.primary,
      ),
      onValueChange = onValueChange
    )
    if (isError) {
      Text(
        color = MaterialTheme.colors.error,
        text = errorMessage ?: ""
      )
    }
  }
}

@Preview("Edit Text Without Icon")
@Composable
fun EditTextInputAuthPreview() {
  Box {
    DefaultOutlinedEditTextInput(
      value = "",
      hint = "Email",
      isError = true,
      isPassword = false,
      errorMessage = "Error in field",
      keyboardType = KeyboardType.Email
    ) {

    }
  }
}