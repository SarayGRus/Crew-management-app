package com.example.crewmanagement.utils

const val MIN_VALUE = 0
fun Int?.checknull(defaultValue: Int = MIN_VALUE) = this ?: defaultValue