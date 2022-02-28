package com.example.crewmanagement.utils

const val EMPTY = ""
const val SPACE = " "

fun String?.checknull(defaultValue: String = EMPTY) = this ?: defaultValue