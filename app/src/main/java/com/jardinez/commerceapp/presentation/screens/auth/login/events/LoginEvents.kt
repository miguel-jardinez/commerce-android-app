package com.jardinez.commerceapp.presentation.screens.auth.login.events

import com.jardinez.commerceapp.domain.models.utils.InputsName
import com.jardinez.commerceapp.domain.models.auth.LoginFormData

sealed class LoginEvents {
  data class OnChangeValue(val value: String, val inputName: InputsName): LoginEvents()
  data class OnSendForm(val data: LoginFormData): LoginEvents()
  object ShowPassword: LoginEvents()
}
