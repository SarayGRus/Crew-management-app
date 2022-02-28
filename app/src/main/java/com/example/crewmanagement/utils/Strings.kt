package com.example.crewmanagement.utils

const val EMPTY = ""
fun String?.checknull(defaultValue: String = EMPTY) = this ?: defaultValue