package com.jardinez.commerceapp.domain.models.auth

data class LoginFormRequest(
  val email: String,
  val password: String
)
