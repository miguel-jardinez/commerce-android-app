package com.jardinez.commerceapp.domain.models.utils

sealed class InputsName {
  object Email: InputsName()
  object Password: InputsName()
  object RepeatPassword: InputsName()
}