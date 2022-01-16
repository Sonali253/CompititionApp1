package com.compititionapp.login.ui.login

import android.text.TextUtils
import android.util.Log
import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.compititionapp.R
import com.compititionapp.login.data.LoginRepository
import com.compititionapp.login.data.Result
import com.compititionapp.login.data.model.LoggedInUser


class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult

    fun login(username: String, password: String) : Result<LoggedInUser>{
        // can be launched in a separate asynchronous job
        val result = loginRepository.login(username, password)
        Log.i("@","result- "+result.toString());
        if (result is Result.Success) {
            _loginResult.value =
                LoginResult(success = LoggedInUserView(displayName = result.data.displayName, userID = result.data.userId))
        } else {
            _loginResult.value = LoginResult(error = R.string.login_failed)
        }
        return result
    }

    fun loginDataChanged(username: String, password: String) {
        if (!isValidPhoneNumber(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        }
        else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        }
        else if(isValidPhoneNumber(username) && isPasswordValid(password)) {
            //Log.i("@","username, password - "+username+password)
            _loginForm.value = LoginFormState(isDataValid = true)
        }
        else{
            _loginForm.value = LoginFormState(usernameError = R.string.empty_username)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    private fun isValidPhoneNumber(phoneNumber: String): Boolean {
        return if (!TextUtils.isEmpty(phoneNumber) ) {
            Patterns.PHONE.matcher(phoneNumber).matches()
        } else false
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length >= 4
    }
}
