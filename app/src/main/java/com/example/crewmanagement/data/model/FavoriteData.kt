package com.example.crewmanagement.data.model

import com.example.crewmanagement.domain.model.FavoriteDomain
import com.example.crewmanagement.utils.checknull
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class FavoriteData(
    @SerializedName("color")
    private val color: String?,
    @SerializedName("food")
    private val food: String?,
    @SerializedName("random_string")
    private val randomString: String?,
    @SerializedName("song")
    private val song: String?
) : Serializable {
    fun toDomainModel(): FavoriteDomain =
        FavoriteDomain(
            color = color?.checknull(),
            food = food?.checknull(),
            randomString = randomString?.checknull(),
            song = randomString?.checknull()
        )
}
