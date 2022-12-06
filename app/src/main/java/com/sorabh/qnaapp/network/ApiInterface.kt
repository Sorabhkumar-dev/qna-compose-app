package com.sorabh.qnaapp.network

import com.sorabh.qnaapp.model.Question
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET("world.json")
    fun getQuestion():Response<List<Question>>
}