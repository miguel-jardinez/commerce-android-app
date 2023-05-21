package com.jardinez.commerceapp.presentation.screens.auth.register.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.jardinez.commerceapp.presentation.components.DefaultOutlinedEditTextInput
import com.jardinez.commerceapp.presentation.components.DefaultPrimaryButton
import com.jardinez.commerceapp.presentation.components.DefaultSpacer

@Composable
fun RegisterForm() {

  Column {
    DefaultOutlinedEditTextInput(
      value = "",
      hint = "",
      isError = false,
      isPassword = false,
      keyboardType = KeyboardType.Email,
    ) {}


    DefaultOutlinedEditTextInput(
      value = "",
      hint = "",
      isError = false,
      isPassword = false,
      keyboardType = KeyboardType.Email,
    ) {}


    DefaultOutlinedEditTextInput(
      value = "",
      hint = "",
      isError = false,
      isPassword = false,
      keyboardType = KeyboardType.Email,
    ) {}

    DefaultOutlinedEditTextInput(
      value = "",
      hint = "",
      isError = false,
      isPassword = false,
      keyboardType = KeyboardType.Email,
    ) {}

    DefaultOutlinedEditTextInput(
      value = "",
      hint = "",
      isError = false,
      isPassword = false,
      keyboardType = KeyboardType.Email,
    ) {}

    DefaultSpacer(size = 18)

    DefaultPrimaryButton(text = "Register") {
      
    }
  }

}

@Preview(showSystemUi = true)
@Composable
fun RegisterFormPreview() {
  RegisterForm()
}