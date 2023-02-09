package com.devtamuno.football.remote.data

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class PlayerRemote(
    @SerialName("id")
    val id: Long,

    @SerialName("name")
    val name: String,

    @SerialName("position")
    val position: String?,

    @SerialName("dateOfBirth")
    val dateOfBirth: String,

    @SerialName("nationality")
    val nationality: String,
)
