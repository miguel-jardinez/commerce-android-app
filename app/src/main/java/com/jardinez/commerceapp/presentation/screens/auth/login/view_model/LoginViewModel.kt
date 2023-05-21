package com.jardinez.commerceapp.presentation.screens.auth.login.view_model

import android.text.TextUtils
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.jardinez.commerceapp.domain.models.utils.InputsName
import com.jardinez.commerceapp.presentation.screens.auth.login.events.LoginEvents
import com.jardinez.commerceapp.presentation.utils.InputState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import android.util.Patterns
import androidx.lifecycle.viewModelScope
import com.jardinez.commerceapp.domain.models.auth.LoginFormData
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {
  private val _emailState = mutableStateOf(InputState( placeholder = "Email" ))
  var emailState: State<InputState> = _emailState

  private val _passwordState = mutableStateOf(InputState( placeholder = "Password", isPassword = true ))
  var passwordState: State<InputState> = _passwordState

  private val _loginState = mutableStateOf(LoginState())
  var loginState: State<LoginState> = _loginState

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

  private fun isEmailValid(email: String): Boolean {
    val isNotEmail = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    val isEmpty = TextUtils.isEmpty(email)
    showErrorMessage(InputsName.Email, false, "")

    Log.d("VALIDATION", "isEmailValid: isEmpy: $isEmpty isNotEmail: $isNotEmail")

    if (isEmpty) {
      showErrorMessage(InputsName.Email, true, "Email input should not empty")
      return false
    }

    if (!isNotEmail) {
      showErrorMessage(InputsName.Email, true, "Email is not an email")
      return false
    }

    showErrorMessage(InputsName.Email, false, "")
    return true
  }

  private fun isPasswordValid(password: String): Boolean {
    val isEmpty = TextUtils.isEmpty(password)
    val correctLength = password.length > 6
    showErrorMessage(InputsName.Password, false, "")

    Log.d("VALIDATION", "isPasswordValid: isEmpy: $isEmpty correctLength: $correctLength ${password.length}")

    if (isEmpty) {
      showErrorMessage(InputsName.Password, true, "Password no should be empty")
      return false
    }

    if(!correctLength) {
      showErrorMessage(InputsName.Password, true, "Password must be more than 6 characters")
      return false
    }

    showErrorMessage(InputsName.Password, false, "")
    return true
  }

  private suspend fun onSubmit(loginForm: LoginFormData) {
    val email = isEmailValid(loginForm.email)
    val password = isPasswordValid(loginForm.password)

    if (email && password) {
      _loginState.value = _loginState.value.copy(loading = true)
      delay(3000)
      _loginState.value = _loginState.value.copy(loading = false)
      Log.d("LoginViewModel", "onSubmit: $loginForm")
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
      else -> {}
    }
  }

}