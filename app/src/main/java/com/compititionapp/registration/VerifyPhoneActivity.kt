package com.compititionapp.registration

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.compititionapp.R
import com.compititionapp.login.network.RestApiService
import com.compititionapp.login.ui.login.LoginActivity
import com.compititionapp.login.ui.login.afterTextChanged
import com.compititionapp.model.UserInfo
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken
import com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks
import com.google.i18n.phonenumbers.NumberParseException
import com.google.i18n.phonenumbers.PhoneNumberUtil
import java.util.concurrent.Executor
import java.util.concurrent.TimeUnit


class VerifyPhoneActivity : AppCompatActivity() {
    private var mAuth: FirebaseAuth? = null
    private var mVerificationId: String? = null
    lateinit var editTextCode: EditText
    lateinit var editTextPassword: EditText
    lateinit var buttonSignUP: Button
    private var mobileNo = ""
    private var password = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verify_phone)
        mAuth = FirebaseAuth.getInstance()
        editTextCode = findViewById<EditText>(R.id.editTextCode)
        editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        buttonSignUP = findViewById<Button>(R.id.buttonRegister)



        editTextCode.afterTextChanged {
            val code = editTextCode.getText().toString().trim { it <= ' ' }
            if (code.isEmpty() || code.length < 6) {
                editTextCode.setError("Enter valid code")
                editTextCode.requestFocus()
            }else if(editTextPassword.text.toString().isEmpty() || editTextPassword.text.toString().length < 8){
                editTextPassword.setError("Password can't be empty!!")
                editTextPassword.requestFocus()
            }
            else {
                password = editTextPassword.text.toString()
                buttonSignUP.isEnabled = true
            }
        }

        editTextPassword.afterTextChanged {
            val code = editTextCode.getText().toString().trim { it <= ' ' }
            if (code.isEmpty() || code.length < 6) {
                editTextCode.setError("Enter valid code")
                editTextCode.requestFocus()
            }else if(editTextPassword.text.toString().isEmpty() || editTextPassword.text.toString().length < 8){
                editTextPassword.setError("Password can't be empty!!")
                editTextPassword.requestFocus()
            }
            else{
                password = editTextPassword.text.toString()
                buttonSignUP.isEnabled = true
            }
        }


        //if the automatic sms detection did not work, user can also enter the code manually
        //so adding a click listener to the button
        //if the automatic sms detection did not work, user can also enter the code manually
//so adding a click listener to the button
        buttonSignUP.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val code = editTextCode.getText().toString().trim { it <= ' ' }
                    //verifying the code entered manually
                    verifyVerificationCode(code)
            }
        })

        val intent = intent
        val mobile = intent.getStringExtra("mobile")
       // Toast.makeText(this@VerifyPhoneActivity, mobile, Toast.LENGTH_LONG).show()
       mobileNo = mobile
        sendVerificationCode(mobile)

    }


    //the method is sending verification code
//the country id is concatenated
//you can take the country id as user input as well
    private fun sendVerificationCode(mobile: String) {

        val phoneUtil: PhoneNumberUtil = PhoneNumberUtil.getInstance()
        try {
            val numberProto = phoneUtil.parse("+91$mobile", "US")
            val options = mAuth?.let {
                PhoneAuthOptions.newBuilder(it)
                    .setPhoneNumber(phoneUtil.format(numberProto,
                        PhoneNumberUtil.PhoneNumberFormat.E164))
                    .setTimeout(60, TimeUnit.SECONDS) // Timeout and unit
                    .setActivity(this)                 // Activity (for callback binding)
                    .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                    .build()
            }

            options?.let { PhoneAuthProvider.verifyPhoneNumber(it) }

        } catch (e: NumberParseException) { // Wrong format
        }

    }

    //the callback to detect the verification status
    private val mCallbacks: OnVerificationStateChangedCallbacks =
        object : OnVerificationStateChangedCallbacks() {
            override fun onVerificationCompleted(phoneAuthCredential: PhoneAuthCredential) { //Getting the code sent by SMS
                val code = phoneAuthCredential.smsCode
                //sometime the code is not detected automatically
//in this case the code will be null
//so user has to manually enter the code
                if (code != null && editTextPassword.text.isNotEmpty()) {
                    editTextCode.setText(code)
                        //verifying the code
                        verifyVerificationCode(code)

                }
            }

            override fun onVerificationFailed(e: FirebaseException) {
                Toast.makeText(this@VerifyPhoneActivity, e.message, Toast.LENGTH_SHORT).show()
            }

            override fun onCodeSent(
                s: String,
                forceResendingToken: ForceResendingToken
            ) {
                super.onCodeSent(s, forceResendingToken)
                //storing the verification id that is sent to the user
                mVerificationId = s
            }
        }
    private fun verifyVerificationCode(code: String) { //creating the credential
        val credential = PhoneAuthProvider.getCredential(mVerificationId!!, code)
        //signing the user
        signInWithPhoneAuthCredential(credential)
    }

    fun addDummyUser(username: String, password: String) {
        Log.d("@","mobileNo-"+username+"password- "+password)
        val apiService = RestApiService()
        val userInfo = UserInfo(
            userMobile = "7620787369",
            Password = "sam12345"
        )
        apiService.addUser(userInfo)
        /*if (it?.userMobile() != null) {
            // it = newly added user parsed as response
            // it?.id = newly added user ID
        } else
            Log.d("@","Error registering new user")*/
    }
    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        mAuth!!.signInWithCredential(credential)
            .addOnCompleteListener(
                this@VerifyPhoneActivity
            ) { task ->
                if (task.isSuccessful) { //verification successful we will start the profile activity
                    addDummyUser(mobileNo,password)
                    val intent =
                        Intent(this@VerifyPhoneActivity, LoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)

                        Log.d("@", "signInWithCredential:success")
                        Toast.makeText(
                            this@VerifyPhoneActivity,
                            "verification successful",
                            Toast.LENGTH_LONG
                        ).show()


                } else { //verification unsuccessful.. display an error message
                    Log.w("@", "signInWithCredential:failure", task.exception)
                    Toast.makeText(this@VerifyPhoneActivity, "verification unsuccessful", Toast.LENGTH_LONG).show()

                }
            }
    }

}


private fun PhoneAuthProvider.verifyPhoneNumber(s: String, l: Long, seconds: TimeUnit, mainThread: Executor?, mCallbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks) {

}
