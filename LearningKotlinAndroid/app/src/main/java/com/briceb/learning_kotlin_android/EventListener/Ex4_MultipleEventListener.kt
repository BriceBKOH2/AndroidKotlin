package com.briceb.learning_kotlin_android.EventListener

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.briceb.learning_kotlin_android.R
import kotlinx.android.synthetic.main.activity_ex4.*
import org.jetbrains.anko.sdk27.coroutines.onCheckedChange
import org.jetbrains.anko.toast

class Ex4_MultipleEventListener : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex4)

        btnOk.setOnClickListener {
            if (chBxVolontaire.isChecked) toast("Je suis volontaire")
            else toast ("vous n'êtes pas volontaire, checké la case \"Je suis volontaire\"")
        }
        swNocturne.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) toast("Mode nocturne activé")
                else toast("Mode nocturne désactivé")
        }

    }
}
