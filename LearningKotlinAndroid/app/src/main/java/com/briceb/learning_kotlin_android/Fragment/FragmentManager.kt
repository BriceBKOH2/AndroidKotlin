package com.briceb.learning_kotlin_android.Fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.briceb.learning_kotlin_android.R
import kotlinx.android.synthetic.main.activity_fragment_manager.*

class FragmentManager : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_manager)
    }

    private fun Fragment.replaceFragment() {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frg_container, this)
        fragmentTransaction.commit()
    }

    fun menuClick(view: View) {
        when (view) {
            btnHome -> HomeFragment().replaceFragment()
            btnNews -> NewsFragment().replaceFragment()
            btnSettings -> SettingsFragment().replaceFragment()
            btnAbout -> AboutFragment().replaceFragment()
        }
    }
}
