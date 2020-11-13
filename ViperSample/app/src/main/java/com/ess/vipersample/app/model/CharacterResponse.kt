package com.ess.vipersample.app.model

import com.google.gson.annotations.SerializedName


data class CharacterResponse(
    @SerializedName("count")
    val count: Int,
    @SerializedName("next")
    val next: String,
    @SerializedName("previous")
    val previous: Any,
    @SerializedName("results")
    val results: List<StarWarsCharacter>
)