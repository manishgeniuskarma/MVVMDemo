package com.example.mvvmdemo.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmdemo.models.QuoteList
import com.example.mvvmdemo.repository.QuotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: QuotesRepository):ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){

            repository.getQuotes(2)
        }

    }

    val quotes :LiveData<QuoteList>

    get() = repository.quotes
}