package com.ess.mvvmsample.data.net

import com.ess.mvvmsample.data.api.HomeApi
import com.ess.mvvmsample.data.model.CharacterResponse
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    private val homeApi: HomeApi

    companion object{
        private const val BASE_URL = "https://swapi.dev/api/"
    }

    init {
        val builder = OkHttpClient.Builder()
        val okHttpClient = builder.build()
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        homeApi = retrofit.create(HomeApi::class.java)
    }

    fun getAllCharacters(): Call<CharacterResponse> {
        return homeApi.getAllCharacters()
    }

}