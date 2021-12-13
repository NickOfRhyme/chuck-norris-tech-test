package com.nickofrhyme.chucknorrisfacts.api

data class JokeRaw(
    val type: String,
    val value: Value
)

data class Value(
    val categories: List<Any>,
    val id: Int,
    val joke: String
)