package com.jardinez.commerceapp.presentation.screens.auth.register.view_model

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jardinez.commerceapp.domain.models.auth.RegisterFormRequest
import com.jardinez.commerceapp.domain.models.utils.InputsName
import com.jardinez.commerceapp.presentation.screens.auth.register.events.RegisterEvents
import com.jardinez.commerceapp.presentation.utils.InputState
import com.jardinez.commerceapp.utils.Validators
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel()
class RegisterViewModel @Inject constructor(
  private val validators: Validators
) : ViewModel() {

  private val _emailState = mutableStateOf(InputState(placeholder = "Enter Email"))
  val emailState: State<InputState> = _emailState

  private val _userNameState = mutableStateOf(InputState(placeholder = "Create User Name"))
  val userNameState: State<InputState> = _userNameState

  private val _phoneNumberState = mutableStateOf(InputState(placeholder = "Contact Number"))
  val phoneNumberState: State<InputState> = _phoneNumberState

  private val _passwordState = mutableStateOf(InputState(placeholder = "Password", isPassword = true))
  val passwordState: State<InputState> = _passwordState

  private val _confirmPassword = mutableStateOf(InputState(placeholder = "Confirm Password", isPassword = true))
  val confirmPassword: State<InputState> = _confirmPassword

  fun onEvent(event: RegisterEvents) {
    when(event) {
      is RegisterEvents.OnChangeValue -> {
        onEnterValueText(event.value, event.inputName)
      }
      is RegisterEvents.OnSubmitForm -> {
        viewModelScope.launch {
          onSubmit(event.data)
        }
      }
      RegisterEvents.ShowPassword -> {
        _passwordState.value = _passwordState.value.copy(isPassword = !_passwordState.value.isPassword)
      }
      RegisterEvents.ShowRepeatedPassword -> {
        _confirmPassword.value = _confirmPassword.value.copy(isPassword = !_confirmPassword.value.isPassword)
      }
    }
  }
  
  private fun onEnterValueText(value: String, inputsName: InputsName) {
    when(inputsName) {
      InputsName.ContactNumber -> {
        _phoneNumberState.value = _phoneNumberState.value.copy(value = value)
      }
      InputsName.Email -> {
        _emailState.value = _emailState.value.copy(value = value)
      }
      InputsName.Password -> {
        _passwordState.value = _passwordState.value.copy(value = value)
      }
      InputsName.RepeatPassword -> {
        _confirmPassword.value = _confirmPassword.value.copy(value = value)
      }
      InputsName.UserName -> {
        _userNameState.value = _phoneNumberState.value.copy(value = value)
      }
    }
  }

  private suspend fun onSubmit(registerRequest: RegisterFormRequest) {
    val isValidForm = iseValidForm(registerRequest)

    if (isValidForm) {
      delay(1500)
      Log.d("registerRequest", "onSubmit: $registerRequest")
    }
  }

  private fun showErrorMessage(inputsName: InputsName, isError: Boolean, message: String) {
    when(inputsName) {
      InputsName.ContactNumber -> {
        _phoneNumberState.value = _phoneNumberState.value.copy(isError = isError, errorMessage = message)
      }
      InputsName.Email -> {
        _emailState.value = _emailState.value.copy(isError = isError, errorMessage = message)
      }
      InputsName.Password -> {
        _passwordState.value = _passwordState.value.copy(isError = isError, errorMessage = message)
      }
      InputsName.RepeatPassword -> {
        _confirmPassword.value = _confirmPassword.value.copy(isError = isError, errorMessage = message)
      }
      InputsName.UserName -> {
        _userNameState.value = _userNameState.value.copy(isError = isError, errorMessage = message)
      }
    }
  }


  private fun iseValidForm(registerRequest: RegisterFormRequest): Boolean {
    val isEmailValid = validators.isEmailValid(registerRequest.email)
    val isUsernameValid = validators.isValidLength(registerRequest.username, 6)
    val isPhoneNumberValid = validators.isValidLength(registerRequest.phoneNumber, 10)
    val isPasswordValid = validators.isPasswordValid(registerRequest.password)
    val isConfirmPasswordValid = validators.comparePassword(registerRequest.password, registerRequest.repeatPassword)

    showErrorMessage(InputsName.Email, isEmailValid.isError, isEmailValid.message)
    showErrorMessage(InputsName.UserName, isUsernameValid.isError, isUsernameValid.message)
    showErrorMessage(InputsName.ContactNumber, isPhoneNumberValid.isError, isPhoneNumberValid.message)
    showErrorMessage(InputsName.Password, isPasswordValid.isError, isPasswordValid.message)
    showErrorMessage(InputsName.RepeatPassword, isConfirmPasswordValid.isError, isConfirmPasswordValid.message)

    val isFormValid = isPasswordValid.isError
      || isPhoneNumberValid.isError
      || isConfirmPasswordValid.isError
      || isEmailValid.isError
      || isUsernameValid.isError

    if (!isFormValid) {
      return false
    }

    return true
  }
}