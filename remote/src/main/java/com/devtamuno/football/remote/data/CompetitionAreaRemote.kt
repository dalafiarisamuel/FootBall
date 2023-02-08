package com.devtamuno.football.remote.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CompetitionAreaRemote(
    @SerialName("id")
    val id: Long,

    @SerialName("name")
    val name: String,

    @SerialName("code")
    val code: String,

    @SerialName("flag")
    val flag: String?,
)
