package com.example.currencyconverter.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.currencyconverter.R
import com.example.currencyconverter.navigation.Navigation
import com.example.currencyconverter.ui.main.CurrencyFragment
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        initViews()
    }

    private fun initViews() {
        initCurrencyFragment()
    }

    private fun initCurrencyFragment() {
        Navigation.replaceFragment(supportFragmentManager, R.id.fragmentContainer, CurrencyFragment())
    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

    companion object {
        private val CLASS_TAG = MainActivity::class.java.simpleName
    }
}
