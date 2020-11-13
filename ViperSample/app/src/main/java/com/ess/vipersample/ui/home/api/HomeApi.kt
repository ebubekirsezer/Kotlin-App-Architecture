package com.ess.vipersample.ui.home.api

import com.ess.vipersample.app.model.CharacterResponse
import com.ess.vipersample.app.model.StarWarsCharacter
import retrofit2.Call
import retrofit2.http.GET

interface HomeApi {
    @GET("people")
    fun getAllCharacters(): Call<CharacterResponse>
}