package com.jardinez.commerceapp.presentation.screens.auth.login.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jardinez.commerceapp.domain.models.auth.LoginFormRequest
import com.jardinez.commerceapp.domain.models.utils.InputsName
import com.jardinez.commerceapp.presentation.components.DefaultOutlinedEditTextInput
import com.jardinez.commerceapp.presentation.components.DefaultPrimaryButton
import com.jardinez.commerceapp.presentation.screens.auth.login.events.LoginEvents
import com.jardinez.commerceapp.presentation.screens.auth.login.view_model.LoginViewModel

@Composable
fun LoginForm(viewModel: LoginViewModel = hiltViewModel()) {
  val emailVm = viewModel.emailState
  val passwordVm = viewModel.passwordState
  val loginState = viewModel.loginState

  Column {
    DefaultOutlinedEditTextInput(
      value = emailVm.value.value,
      hint = emailVm.value.placeholder,
      isError = emailVm.value.isError,
      errorMessage = emailVm.value.errorMessage,
      isPassword = emailVm.value.isPassword,
      keyboardType = KeyboardType.Email,
    ) {
      viewModel.onEvent(LoginEvents.OnChangeValue(it, InputsName.Email))
    }

    DefaultOutlinedEditTextInput(
      value = passwordVm.value.value,
      hint = passwordVm.value.placeholder,
      isError = passwordVm.value.isError,
      errorMessage = passwordVm.value.errorMessage,
      isPassword = passwordVm.value.isPassword,
      keyboardType = KeyboardType.Password,
      onClickTrailingIcon = {
        viewModel.onEvent(LoginEvents.ShowPassword)
      },
      trailingIcon = Icons.Default.Lock,
    ) {
      viewModel.onEvent(LoginEvents.OnChangeValue(it, InputsName.Password))
    }

    Text(
      text = "Forget your password?",
      modifier = Modifier
        .padding(vertical = 16.dp)
        .fillMaxWidth(),
      textAlign = TextAlign.End,
    )
    DefaultPrimaryButton(text = "Login", loading = loginState.value.loading) {
      viewModel.onEvent(
          LoginEvents.OnSendForm(
            LoginFormRequest(
              email = emailVm.value.value,
              password = passwordVm.value.value
            )
          )
        )
    }

  }
}

@Preview(showSystemUi = true)
@Composable
fun LoginFormPreview() {
  LoginFormPreview()
}
