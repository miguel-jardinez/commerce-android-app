package com.jardinez.commerceapp.presentation.utils

data class InputState(
  val isError: Boolean = false,
  val value: String = "",
  val placeholder: String = "",
  val errorMessage: String = "",
  val wasFocused: Boolean = false,
  val isPassword: Boolean = false,
)
