package com.devtamuno.football.remote.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CompetitionRemote(
    @SerialName("id")
    val id: Long,

    @SerialName("name")
    val name: String,

    @SerialName("code")
    val code: String,

    @SerialName("type")
    val type: String,

    @SerialName("emblem")
    val emblem: String,

    @SerialName("area")
    val area: CompetitionAreaRemote,

    @SerialName("currentSeason")
    val currentSeason: CompetitionSeasonRemote,

    @SerialName("numberOfAvailableSeason")
    val numberOfAvailableSeason: Int?,

    @SerialName("lastUpdated")
    val lastUpdated: String,
)
