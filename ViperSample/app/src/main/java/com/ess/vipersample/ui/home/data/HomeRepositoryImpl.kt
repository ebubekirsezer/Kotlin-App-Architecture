package com.ess.vipersample.ui.home.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ess.vipersample.app.model.CharacterResponse
import com.ess.vipersample.app.model.StarWarsCharacter
import com.ess.vipersample.app.net.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeRepositoryImpl : HomeRepository {

    private val retrofitClient = RetrofitClient()

    override fun getAllCharacters(): LiveData<List<StarWarsCharacter>> {

        val data = MutableLiveData<List<StarWarsCharacter>>()

        retrofitClient.getAllCharacters().enqueue(object : Callback<CharacterResponse> {
            override fun onResponse(
                call: Call<CharacterResponse>,
                response: Response<CharacterResponse>
            ) {
                println(response.body()?.results)
                data.value = response.body()?.results
            }

            override fun onFailure(call: Call<CharacterResponse>, t: Throwable) {
                println("Message: " + t)
                println("Hata: OnFailure")
            }
        })
        return data
    }
}