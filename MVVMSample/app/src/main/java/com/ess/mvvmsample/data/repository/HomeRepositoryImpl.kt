package com.ess.mvvmsample.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ess.mvvmsample.data.model.CharacterResponse
import com.ess.mvvmsample.data.model.StarWarsCharacter
import com.ess.mvvmsample.data.net.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeRepositoryImpl : HomeRepository {

    private val retrofitClient = RetrofitClient()

    override fun getAllCharacters(): LiveData<List<StarWarsCharacter>> {

        var data = MutableLiveData<List<StarWarsCharacter>>()

        retrofitClient.getAllCharacters().enqueue(object : Callback<CharacterResponse> {
            override fun onResponse(
                call: Call<CharacterResponse>,
                response: Response<CharacterResponse>
            ) {
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