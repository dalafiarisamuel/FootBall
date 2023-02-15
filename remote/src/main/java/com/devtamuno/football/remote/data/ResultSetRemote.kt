package com.devtamuno.football.remote.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ResultSetRemote(
    @SerialName("count")
    val count: Long,

    @SerialName("first")
    val firstGamePlayDate: String,

    @SerialName("last")
    val lastGamePlayDate: String,

    @SerialName("played")
    val played: Int
)
