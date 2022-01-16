package com.compititionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.compititionapp.Util.PrefManager
import com.compititionapp.login.ui.login.LoginActivity
import com.compititionapp.registration.SignUpActivity

class SplashScreenActivity : AppCompatActivity() {

       override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen_acitivity)
       /* var btnSignIn = findViewById<Button>(R.id.btnSignIn)
        var btnSignUp = findViewById<Button>(R.id.btnSignUp)*/

           var prefManager = PrefManager()
           prefManager.context = this
           prefManager.checkLogin()


          /* btnSignIn.setOnClickListener {
            val intent = Intent(this@SplashScreenActivity, LoginActivity::class.java)
            startActivity(intent)
        }


        btnSignUp.setOnClickListener {
            val intent = Intent(this@SplashScreenActivity, SignUpActivity::class.java)
            startActivity(intent)
        }*/
    }
}
