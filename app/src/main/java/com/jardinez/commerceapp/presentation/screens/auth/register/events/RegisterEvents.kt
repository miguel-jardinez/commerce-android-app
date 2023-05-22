package com.jardinez.commerceapp.presentation.screens.auth.register.events

import com.jardinez.commerceapp.domain.models.auth.RegisterFormRequest
import com.jardinez.commerceapp.domain.models.utils.InputsName

sealed class RegisterEvents {
  data class OnChangeValue(val value: String, val inputName: InputsName): RegisterEvents()
  data class OnSubmitForm(val data: RegisterFormRequest): RegisterEvents()
  object ShowPassword: RegisterEvents()
  object ShowRepeatedPassword: RegisterEvents()
}
