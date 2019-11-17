package com.example.currencyconverter.ui

import android.app.Application
import com.example.currencyconverter.R
import com.example.currencyconverter.di.initDI
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        CalligraphyConfig.initDefault(
            CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/Montserrat-Bold.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        )

        initDI()
    }
}
