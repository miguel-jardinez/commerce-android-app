package com.jardinez.commerceapp.presentation.screens.auth.login.view_model

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.jardinez.commerceapp.domain.models.utils.InputsName
import com.jardinez.commerceapp.presentation.screens.auth.login.events.LoginEvents
import com.jardinez.commerceapp.presentation.utils.InputState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.jardinez.commerceapp.domain.models.auth.LoginFormRequest
import com.jardinez.commerceapp.presentation.screens.auth.login.events.UIEvents
import com.jardinez.commerceapp.utils.Validators
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

@HiltViewModel
class LoginViewModel @Inject constructor(
  private val validators: Validators
) : ViewModel() {
  private val _emailState = mutableStateOf(InputState( placeholder = "Email" ))
  var emailState: State<InputState> = _emailState

  private val _passwordState = mutableStateOf(InputState( placeholder = "Password", isPassword = true ))
  var passwordState: State<InputState> = _passwordState

  private val _loginState = mutableStateOf(LoginState())
  var loginState: State<LoginState> = _loginState

  private val _uiEvent = Channel<UIEvents>()
  val uiEvents = _uiEvent.receiveAsFlow()

  fun onEvent(event: LoginEvents) {
    when(event) {
      is LoginEvents.OnSendForm -> {
        viewModelScope.launch {
          onSubmit(event.data)
        }
      }

      is LoginEvents.OnChangeValue -> {
        onEnterValueText(event.value, event.inputName)
      }

      LoginEvents.ShowPassword -> {
        _passwordState.value = _passwordState.value.copy(isPassword = !_passwordState.value.isPassword)
      }
    }
  }

  private fun onEnterValueText(value: String, input: InputsName) {
    when(input) {
      InputsName.Email -> {
        _emailState.value = _emailState.value.copy(value = value)
      }
      else -> {
        _passwordState.value = _passwordState.value.copy(value = value)
      }
    }
  }

  private suspend fun onSubmit(loginForm: LoginFormRequest) {
    val email = validators.isEmailValid(loginForm.email)
    val password = validators.isPasswordValid(loginForm.password)

    showErrorMessage(InputsName.Email, email.isError, email.message)
    showErrorMessage(InputsName.Password, password.isError, password.message)

    if (!email.isError && !password.isError) {
      _loginState.value = _loginState.value.copy(loading = true)
      delay(timeMillis = 1000)
      _loginState.value = _loginState.value.copy(loading = false)
      _uiEvent.send(UIEvents.NavigateToLogin)
    }
  }

  private fun showErrorMessage(input: InputsName, state: Boolean, errorMessage: String = "") {
    when(input) {
      InputsName.Email -> {
        _emailState.value = _emailState.value.copy(isError = state, errorMessage = errorMessage)
      }
      InputsName.Password -> {
        _passwordState.value = _passwordState.value.copy(isError = state, errorMessage = errorMessage)
      }
      else -> Unit
    }
  }

}