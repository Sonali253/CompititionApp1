package com.compititionapp.login.ui.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.*
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.compititionapp.R
import com.compititionapp.Util.PrefManager
import com.compititionapp.home_screen.HomeScreenActivity
import com.compititionapp.personlize.PersonlizeActivity
import com.compititionapp.registration.SignUpActivity
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        val username = findViewById<EditText>(R.id.username)
        val password = findViewById<EditText>(R.id.password)
        val login = findViewById<Button>(R.id.login)
        val loading = findViewById<ProgressBar>(R.id.loading)
        val linearLayoutSignUp = findViewById<LinearLayout>(R.id.linearLayoutSignUp)

        var prefManager = PrefManager()
        prefManager.context = this

        linearLayoutSignUp.setOnClickListener {
            val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        loginViewModel = ViewModelProviders.of(this, LoginViewModelFactory())
            .get(LoginViewModel::class.java)

        loginViewModel.loginFormState.observe(this@LoginActivity, Observer {
            val loginState = it ?: return@Observer

            // disable login button unless both username / password is valid
           // login.isEnabled = loginState.isDataValid

            if (loginState.usernameError != null) {
                username.error = getString(loginState.usernameError)
            }
            if (loginState.passwordError != null) {
                password.error = getString(loginState.passwordError)
            }
        })

        loginViewModel.loginResult.observe(this@LoginActivity, Observer {
            val loginResult = it ?: return@Observer

            loading.visibility = View.GONE
            if (loginResult.error != null) {
                showLoginFailed(loginResult.error)
            }
            if (loginResult.success != null) {
                updateUiWithUser(loginResult.success)
            }
            setResult(Activity.RESULT_OK)

        })

        username.afterTextChanged {
            loginViewModel.loginDataChanged(
                username.text.toString(),
                password.text.toString()
            )
            if (username.text.toString().isEmpty() || username.text.toString().length < 10) {
                username.error = "Enter a valid mobile"
                username.requestFocus()
            }
        }

        password.apply {
            afterTextChanged {
                Log.i("@","password.text- "+password.text.toString())
                loginViewModel.loginDataChanged(
                    username.text.toString(),
                    password.text.toString()
                )
                if (username.text.toString().isEmpty() || username.text.toString().length < 10) {
                    username.error = "Enter a valid mobile"
                    username.requestFocus()
                }
            }

            setOnEditorActionListener { _, actionId, _ ->
                when (actionId) {
                    EditorInfo.IME_ACTION_DONE ->{
                        Log.i("@","setOnEditorActionListener - "+password)
                        loginViewModel.login(
                            username.text.toString(),
                            password.text.toString()
                        )
                    }

                }
                false
            }

            login.setOnClickListener {

               loginViewModel.loginDataChanged(
                        username.text.toString(),
                        password.text.toString()
                    )

                //loading.visibility = View.VISIBLE
                //loginViewModel.login(username.text.toString(), password.text.toString())

                //validate form

                if (validateLogin(username.text.toString(), password.text.toString())) { //do login
                    loading.visibility = View.GONE
                    loginViewModel.login(username.text.toString(), password.text.toString())
                }
            }
        }
    }


    private fun validateLogin(
        username: String?,
        password: String?
    ): Boolean {
        if (username == null || username.trim { it <= ' ' }.length == 0) {
            Toast.makeText(applicationContext, "Username is required", Toast.LENGTH_SHORT).show()
            return false
        }
        if (password == null || password.trim { it <= ' ' }.length == 0) {
            Toast.makeText(applicationContext, "Password is required", Toast.LENGTH_SHORT).show()
            return false
        }
        return true
    }

    private fun updateUiWithUser(model: LoggedInUserView) {
        var prefManager = PrefManager()
        prefManager.context = this
        prefManager.createLoginSession(username.text.toString(),model.userID)

        val intent = Intent(this@LoginActivity, PersonlizeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
    }


}

/**
 * Extension function to simplify setting an afterTextChanged action to EditText components.
 */
fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(editable: Editable?) { afterTextChanged.invoke(editable.toString()) }
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
    })
}
