package com.ess.mvvmsample.data.api

import com.ess.mvvmsample.data.model.CharacterResponse
import retrofit2.Call
import retrofit2.http.GET

interface HomeApi {
    @GET("people")
    fun getAllCharacters(): Call<CharacterResponse>
}