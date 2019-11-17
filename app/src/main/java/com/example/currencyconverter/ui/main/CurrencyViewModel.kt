package com.example.currencyconverter.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.currencyconverter.utils.ScopedViewModel
import com.example.domain.Currency
import com.example.usecases.GetLatestCurrencies
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch

class CurrencyViewModel(
    private val getCurrencies: GetLatestCurrencies,
    uiDispatcher: CoroutineDispatcher
) : ScopedViewModel(uiDispatcher) {

    private val uiModel = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (uiModel.value == null) refresh()
            return uiModel
        }

    sealed class UiModel {
        object Loading : UiModel()
        class Content(val currencies: MutableList<Currency>) : UiModel()
        object showUI : UiModel()
    }

    init {
        initScope()
    }

    private fun refresh() {
        uiModel.value = UiModel.showUI
    }

    fun showUi() {
        launch {
            uiModel.value = UiModel.Loading
            uiModel.value = UiModel.Content(getCurrencies.invoke() as MutableList<Currency>)
        }
    }

    override fun onCleared() {
        destroyScope()
        super.onCleared()
    }
}