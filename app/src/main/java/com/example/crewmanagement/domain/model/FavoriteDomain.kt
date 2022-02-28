package com.example.crewmanagement.domain.model

import java.io.Serializable

data class FavoriteDomain(
    private val color: String?,
    private val food: String?,
    private val randomString: String?,
    private val song: String?
): Serializable {
}
