package com.example.crewmanagement.data.model

import com.example.crewmanagement.domain.model.OompaLoompaDomain
import com.example.crewmanagement.utils.checknull
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class OompaLoompaData(
    @SerializedName("first_name")
    private val firstName: String?,
    @SerializedName("last_name")
    private val lastName: String?,
    @SerializedName("favorite")
    private val favorite: FavoriteData?,
    @SerializedName("gender")
    private val gender: String?,
    @SerializedName("image")
    private val image: String?,
    @SerializedName("profession")
    private val profession: String?,
    @SerializedName("email")
    private val email: String?,
    @SerializedName("age")
    private val age: Int?,
    @SerializedName("country")
    private val country: String?,
    @SerializedName("height")
    private val height: Int?,
    @SerializedName("id")
    private val id: Int?

) : Serializable {
    fun toDomainModel(): OompaLoompaDomain =
        OompaLoompaDomain(
            firstName = firstName?.checknull(),
            lastName = lastName?.checknull(),
            favorite = favorite?.toDomainModel(),
            gender = gender?.checknull(),
            image = image?.checknull(),
            profession = profession?.checknull(),
            email = email?.checknull(),
            age = age?.checknull(),
            country = country?.checknull(),
            height = height?.checknull(),
            id = id?.checknull()
        )
}
