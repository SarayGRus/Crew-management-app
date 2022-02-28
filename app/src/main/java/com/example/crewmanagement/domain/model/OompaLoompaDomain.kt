package com.example.crewmanagement.domain.model

import com.google.gson.annotations.SerializedName

data class OompaLoompaDomain(
    private val firstName: String?,
    private val lastName: String?,
    private val favorite: FavoriteDomain?,
    private val gender: String?,
    private val image: String?,
    private val profession: String?,
    private val email: String?,
    private val age: Int?,
    private val country: String?,
    private val height: Int?,
    private val id: Int?

) {

}
