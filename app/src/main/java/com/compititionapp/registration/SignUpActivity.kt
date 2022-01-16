package com.compititionapp.registration



import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.compititionapp.R
import com.compititionapp.SplashScreenActivity


class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var editTextMobile = findViewById<EditText>(R.id.edtTxtmobile)
        var button = findViewById<Button>(R.id.button)

       /* // toolbar
        var toolbar: Toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        // add back arrow to toolbar
        // add back arrow to toolbar
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }*/

        button.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                val mobile: String = editTextMobile.text.toString().trim()
                if (mobile.isEmpty() || mobile.length < 10) {
                    editTextMobile.error = "Enter a valid mobile"
                    editTextMobile.requestFocus()
                    return
                }
                val intent = Intent(this@SignUpActivity, VerifyPhoneActivity::class.java)
                intent.putExtra("mobile", mobile)
                startActivity(intent)
            }
        })

    }

    override fun onBackPressed() {
        val intent = Intent(this@SignUpActivity, SplashScreenActivity::class.java)
        startActivity(intent)
    }

   /* override fun onOptionsItemSelected(item: MenuItem): Boolean { // handle arrow click here
        if (item.getItemId() === android.R.id.home) {
            finish() // close this activity and return to preview activity (if there is any)
        }
        return super.onOptionsItemSelected(item)
    }*/
}
