package com.devtamuno.football.remote.data

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class CoachRemote(

    @SerialName("id")
    val id: Long?,

    @SerialName("firstName")
    val firstName: String?,

    @SerialName("lastName")
    val lastName: String?,

    @SerialName("name")
    val name: String?,

    @SerialName("dateOfBirth")
    val dateOfBirth: String?,

    @SerialName("nationality")
    val nationality: String?,
)
