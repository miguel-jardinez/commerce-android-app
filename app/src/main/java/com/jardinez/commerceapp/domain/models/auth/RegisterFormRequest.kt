package com.jardinez.commerceapp.domain.models.auth

data class RegisterFormRequest(
  val email: String,
  val username: String,
  val phoneNumber: String,
  val password: String,
  val repeatPassword: String
)
