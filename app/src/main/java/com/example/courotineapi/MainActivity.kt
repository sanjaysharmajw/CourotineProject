package com.example.courotineapi
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.courotineapi.Adapters.CustomAdapter
import com.example.courotineapi.MainViewModelFactory.MainViewModelFactory
import com.example.courotineapi.ViewModels.MainViewModel
import com.example.courotineapi.api.QuotesAPI
import com.example.courotineapi.api.RetrofitHelper
import com.example.courotineapi.models.Result
import com.example.courotineapi.repository.QuotesRepository

class MainActivity : AppCompatActivity() {

    private val dataValue = ArrayList<Result>()
    lateinit var  mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recycleView = findViewById<RecyclerView>(R.id.recycleViewId)

        val quoteService = RetrofitHelper.getInstance().create(QuotesAPI::class.java)
        val  repository = QuotesRepository(quoteService)

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)
        mainViewModel.quotes.observe(this) {

                val quoteList = it
                if (quoteList != null) {
                    dataValue += quoteList.results
                }
                val adapter = CustomAdapter(dataValue)
                recycleView.adapter = adapter

            }
        }
        }


