package com.example.currencyconverter.ui.main

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.currencyconverter.R
import com.example.currencyconverter.ui.extensions.inflate
import com.example.domain.Currency
import kotlinx.android.synthetic.main.fragment_currency.*
import org.koin.android.scope.currentScope
import org.koin.android.viewmodel.ext.android.viewModel

class CurrencyFragment : Fragment() {
    private lateinit var amount: String
    private lateinit var adapter: CurrencyAdapter
    private var currenciesList: MutableList<Currency> = mutableListOf()

    private val viewModel: CurrencyViewModel by currentScope.viewModel(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return container?.inflate(R.layout.fragment_currency)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mLayoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        currencyList.layoutManager = mLayoutManager
        currencyList.setHasFixedSize(true)

        adapter = CurrencyAdapter()
        currencyList.adapter = adapter

        viewModel.model.observe(this, Observer(::updateUi))
    }

    private fun updateUi(model: CurrencyViewModel.UiModel) {

        containerProgressIndicator.visibility =
            if (model is CurrencyViewModel.UiModel.Loading) View.VISIBLE else View.GONE

        when (model) {
            is CurrencyViewModel.UiModel.Content -> {
                currenciesList = adapter.currencies
                adapter.currencies = model.currencies

                amount = amountEditText.text.toString()

                amountEditText.setOnEditorActionListener(object : TextView.OnEditorActionListener {
                    override fun onEditorAction(text: TextView, actionId: Int, event: KeyEvent?): Boolean {
                        if (actionId == EditorInfo.IME_ACTION_SEARCH
                            || actionId == EditorInfo.IME_ACTION_DONE
                            || event?.action == KeyEvent.ACTION_DOWN
                            && event.keyCode == KeyEvent.KEYCODE_ENTER) {

                            amount = text.text.toString()
                            adapter.setAmount(adapter.currencies[0], amount.toInt())
                            return true
                        }

                        return false
                    }
                })
            }
            CurrencyViewModel.UiModel.showUI -> {
                viewModel.showUi()
            }
        }

        adapter.notifyDataSetChanged()
    }
}