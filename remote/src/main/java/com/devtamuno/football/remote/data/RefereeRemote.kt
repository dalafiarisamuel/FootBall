package com.devtamuno.football.remote.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RefereeRemote(

    @SerialName("id")
    val id: Long?,

    @SerialName("name")
    val name: String?,

    @SerialName("type")
    val type: String?,

    @SerialName("nationality")
    val nationality: String?,
)
