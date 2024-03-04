package com.example.courotineapi.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.courotineapi.api.QuotesAPI
import com.example.courotineapi.models.QuoteList

class QuotesRepository (private  val  quotesAPI: QuotesAPI){

    private  val quotesLiveData = MutableLiveData<QuoteList>()

    val quotes:LiveData<QuoteList> get() = quotesLiveData

    suspend fun getQuotes(page: Int) {
        val  result = quotesAPI.getQuotes(page)
        if (result.body() !=null){
            quotesLiveData.postValue(result.body())
        }
    }

}