package com.briceb.learning_kotlin_android.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.briceb.learning_kotlin_android.MainActivity
import com.briceb.learning_kotlin_android.R
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btnLogin.setOnClickListener {
            val password = editPassword.text.toString()
            if (checkBoxGenCond.isChecked) {
                if (password == "password") {
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    intent.putExtra(EXTRA_PASSWORD, password)
                    startActivity(intent)
                }
                else {
                    toast("Mauvais password")
                    editPassword.setText("")
                }
            }
            else {
                toast("Les conditions générales doivent être approuvées")
            }
        }
    }


}
