package com.example.crewmanagement.domain.model

import java.io.Serializable

data class OompaLoompaDomain(
    val firstName: String?,
    val lastName: String?,
    val description: String?,
    val favorite: FavoriteDomain?,
    val gender: String?,
    val image: String?,
    val profession: String?,
    val email: String?,
    val age: Int?,
    val country: String?,
    val height: Int?,
    val id: Int?

): Serializable
