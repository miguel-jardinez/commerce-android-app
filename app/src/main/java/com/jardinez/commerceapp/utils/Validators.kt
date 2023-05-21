package com.jardinez.commerceapp.utils

import android.text.TextUtils
import android.util.Patterns
import com.jardinez.commerceapp.utils.models.ErrorInput
import javax.inject.Inject

class Validators @Inject constructor() {

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
    val correctLength = password.length > 6

    if (isEmpty) {
      return ErrorInput("Password should not to be empty", true)
    }

    if(!correctLength) {
      return ErrorInput("Password should be more than 6 characters", true)
    }

    return ErrorInput("", false)
  }
}