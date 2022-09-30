package com.example.mvvmdemo.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmdemo.api.QuoteService
import com.example.mvvmdemo.models.QuoteList
import java.lang.reflect.Array.get

class QuotesRepository(private val quoteService: QuoteService) {


    private val quotesLivedata = MutableLiveData<QuoteList>()

                val quotes : LiveData<QuoteList>
                 get() = quotesLivedata

    suspend fun  getQuotes(page:Int){



        val result = quoteService.getQuotes(page)
        if (result?.body() != null) {
            quotesLivedata.postValue(result.body())

        }
    }
}