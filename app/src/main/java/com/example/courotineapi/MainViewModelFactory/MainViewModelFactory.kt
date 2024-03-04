package com.example.courotineapi.MainViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.courotineapi.ViewModels.MainViewModel
import com.example.courotineapi.repository.QuotesRepository

class MainViewModelFactory  (private  val  repository: QuotesRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}