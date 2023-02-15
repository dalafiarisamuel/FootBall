package com.devtamuno.football.remote.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ErrorDataRemote(
    @SerialName("message")
    val message: String,

    @SerialName("errorCode")
    val errorCode: Int?,

    @SerialName("error")
    val error: Int?,
)
