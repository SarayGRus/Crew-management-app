package com.example.crewmanagement.domain.model

import java.io.Serializable

data class FavoriteDomain(
    val color: String?,
    val food: String?,
    val randomString: String?,
    val song: String?
) : Serializable
