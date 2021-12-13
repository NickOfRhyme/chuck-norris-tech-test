package com.nickofrhyme.chucknorrisfacts.api

data class JokeListRaw(
    val type: String,
    val value: List<Value>
)