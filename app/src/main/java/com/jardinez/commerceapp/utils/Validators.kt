package com.jardinez.commerceapp.utils

import android.text.TextUtils
import android.util.Patterns
import com.jardinez.commerceapp.utils.models.ErrorInput
import javax.inject.Inject

class Validators @Inject constructor() {

  fun isValidLength(value: String, length:Int): ErrorInput {
    val dataLength = value.length

    if (dataLength < length) {
      return ErrorInput("Value must be more than $length", true)
    }

    return ErrorInput("", false)
  }

  fun isEmailValid(email: String): ErrorInput {
    val isNotEmail = Patterns.EMAIL_ADDRESS.matcher(email).matches()
    val isEmpty = TextUtils.isEmpty(email)

    if (isEmpty) {
      return ErrorInput("Email should not to be empty", true)
    }

    if (!isNotEmail) {
      return ErrorInput("Email is not an email", true)
    }

    return ErrorInput("", false)
  }

  fun isPasswordValid(password: String): ErrorInput {
    val isEmpty = TextUtils.isEmpty(password)

    if (isEmpty) {
      return ErrorInput("Password should not to be empty", true)
    }

    isValidLength(password, 6)

    return ErrorInput("", false)
  }

  fun comparePassword(password: String, repeatedPassword: String): ErrorInput {
    if (password != repeatedPassword) {
      return ErrorInput("Password does not match", true)
    }

    return ErrorInput("", false)
  }
}