package com.example.mvvmdemo.api


import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    private const val Base_url = "https://quotable.io/"

    fun getInstance(): Retrofit {

        return Retrofit.Builder()
            .baseUrl(Base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}