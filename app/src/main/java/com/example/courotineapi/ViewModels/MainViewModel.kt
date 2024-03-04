package com.example.courotineapi.ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.courotineapi.models.QuoteList
import com.example.courotineapi.repository.QuotesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel (private  val repository: QuotesRepository):ViewModel(){

  init {
      viewModelScope.launch (Dispatchers.IO){
          repository.getQuotes(1)
      }
  }
    val  quotes : LiveData<QuoteList> get() = repository.quotes

}