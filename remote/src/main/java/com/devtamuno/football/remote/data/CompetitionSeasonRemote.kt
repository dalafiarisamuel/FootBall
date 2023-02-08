package com.devtamuno.football.remote.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CompetitionSeasonRemote(
    @SerialName("id")
    val id: Int,

    @SerialName("startDate")
    val startDate: String,

    @SerialName("endDate")
    val endDate: String,

    @SerialName("currentMatchDay")
    val currentMatchDay: Int?,
)
