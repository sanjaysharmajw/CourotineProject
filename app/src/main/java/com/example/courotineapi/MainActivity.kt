package com.example.courotineapi
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val dataValue = ArrayList<Result>()

    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recycleView = findViewById<RecyclerView>(R.id.recycleViewId)

        val quotesAPi = RetrofitHelper.getInstance().create(QuotesAPI::class.java)
        GlobalScope.launch {
            (Dispatchers.Main)
            val result = quotesAPi.getQuotes(1)
            runOnUiThread {
                val quoteList = result.body()
                if (quoteList != null) {
                    dataValue += quoteList.results
                }
                val adapter = CustomAdapter(dataValue)
                recycleView.adapter = adapter
                }
            }
        }

    }
