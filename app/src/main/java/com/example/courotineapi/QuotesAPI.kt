package com.example.courotineapi

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface QuotesAPI {

    @GET("/quotes")
    suspend fun getQuotes(@Query("page") page: Int): Response<QuoteList>

}