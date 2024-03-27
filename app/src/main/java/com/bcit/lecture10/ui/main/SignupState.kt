package com.bcit.lecture10.ui.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class SignupState() {

    // name state
    var name by mutableStateOf("")
    val onNameChanged:(String)->Unit = {
        name = it
    }

    //email state
    var email by mutableStateOf("")
    val onEmailChanged:(String)->Unit = {
        email = it
        validEmail = email.contains("@")
    }
    var validEmail = false
}