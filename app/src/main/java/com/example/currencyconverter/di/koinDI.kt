package com.example.currencyconverter.di

import android.app.Application
import com.example.currencyconverter.data.database.CurrencyDatabase
import com.example.currencyconverter.data.database.RoomDataSource
import com.example.currencyconverter.data.server.CurrencyDataSource
import com.example.currencyconverter.ui.main.CurrencyFragment
import com.example.currencyconverter.ui.main.CurrencyViewModel
import com.example.data.repository.CurrencyRepository
import com.example.data.source.LocalDataSource
import com.example.data.source.RemoteDataSource
import com.example.usecases.GetLatestCurrencies
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun Application.initDI() {
    startKoin {
        androidLogger()
        androidContext(this@initDI)
        modules(listOf(appModule, dataModule, scopesModule))
    }
}

private val appModule = module {
    single { CurrencyDatabase.build(get()) }
    factory<LocalDataSource> { RoomDataSource(get()) }
    factory<RemoteDataSource> { CurrencyDataSource() }
    single<CoroutineDispatcher> { Dispatchers.Main }
}

val dataModule = module {
    factory { CurrencyRepository(get(), get()) }
}

private val scopesModule = module {
    scope(named<CurrencyFragment>()) {
        viewModel { CurrencyViewModel(get(), get()) }
        scoped { GetLatestCurrencies(get()) }
    }
}