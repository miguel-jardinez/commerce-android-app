package com.jardinez.commerceapp.presentation.screens.auth.register.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.jardinez.commerceapp.domain.models.auth.RegisterFormRequest
import com.jardinez.commerceapp.domain.models.utils.InputsName
import com.jardinez.commerceapp.presentation.components.DefaultOutlinedEditTextInput
import com.jardinez.commerceapp.presentation.components.DefaultPrimaryButton
import com.jardinez.commerceapp.presentation.components.DefaultSpacer
import com.jardinez.commerceapp.presentation.screens.auth.register.events.RegisterEvents
import com.jardinez.commerceapp.presentation.screens.auth.register.view_model.RegisterViewModel

@Composable
fun RegisterForm(
  viewModel: RegisterViewModel = hiltViewModel()
) {
  val onEvent = viewModel::onEvent
  val email = viewModel.emailState.value
  val username = viewModel.userNameState.value
  val phoneNumber = viewModel.phoneNumberState.value
  val password = viewModel.passwordState.value
  val confirmPassword = viewModel.confirmPassword.value

  Column {
    DefaultOutlinedEditTextInput(
      value = email.value,
      hint = email.placeholder,
      isError = email.isError,
      isPassword = email.isPassword,
      errorMessage = email.errorMessage,
      keyboardType = KeyboardType.Email,
    ) {
      onEvent(RegisterEvents.OnChangeValue(it, InputsName.Email))
    }


    DefaultOutlinedEditTextInput(
      value = username.value,
      hint = username.placeholder,
      isError = username.isError,
      isPassword = username.isPassword,
      errorMessage = username.errorMessage,
      keyboardType = KeyboardType.Text,
    ) {
      onEvent(RegisterEvents.OnChangeValue(it, InputsName.UserName))
    }


    DefaultOutlinedEditTextInput(
      value = phoneNumber.value,
      hint = phoneNumber.placeholder,
      isError = phoneNumber.isError,
      isPassword = phoneNumber.isPassword,
      errorMessage = phoneNumber.errorMessage,
      keyboardType = KeyboardType.Phone,
    ) {
      onEvent(RegisterEvents.OnChangeValue(it, InputsName.ContactNumber))
    }

    DefaultOutlinedEditTextInput(
      value = password.value,
      hint = password.placeholder,
      isError = password.isError,
      isPassword = password.isPassword,
      errorMessage = password.errorMessage,
      keyboardType = KeyboardType.Password,
      trailingIcon = Icons.Default.Lock,
      onClickTrailingIcon = {
        onEvent(RegisterEvents.ShowPassword)
      }
    ) {
      onEvent(RegisterEvents.OnChangeValue(it, InputsName.Password))
    }

    DefaultOutlinedEditTextInput(
      value = confirmPassword.value,
      hint = confirmPassword.placeholder,
      isError = confirmPassword.isError,
      isPassword = confirmPassword.isPassword,
      errorMessage = confirmPassword.errorMessage,
      trailingIcon = Icons.Default.Lock,
      onClickTrailingIcon = {
        onEvent(RegisterEvents.ShowRepeatedPassword)
      },
      keyboardType = KeyboardType.Password,
    ) {
      onEvent(RegisterEvents.OnChangeValue(it, InputsName.RepeatPassword))
    }

    DefaultSpacer(size = 18)

    DefaultPrimaryButton(text = "Register") {
      viewModel.onEvent(
        RegisterEvents
          .OnSubmitForm(data = RegisterFormRequest(
            email = email.value,
            username = username.value,
            phoneNumber = phoneNumber.value,
            password =  password.value,
            repeatPassword = confirmPassword.value
          ))
      )
    }
  }

}

@Preview(showSystemUi = true)
@Composable
fun RegisterFormPreview() {
  RegisterForm()
}