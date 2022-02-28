package com.example.crewmanagement.utils

const val EMPTY = ""
const val SPACE = " "
const val OOMPA_LOOMPA_ID = "OOMPA_LOOMPA_ID"
const val NOT_AVAILABLE = "No disponible"

fun String?.checknull(defaultValue: String = EMPTY) = this ?: defaultValue