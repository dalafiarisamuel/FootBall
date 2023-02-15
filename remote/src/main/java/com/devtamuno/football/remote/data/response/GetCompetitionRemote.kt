package com.devtamuno.football.remote.data.response

import com.devtamuno.football.remote.data.CompetitionAreaRemote
import com.devtamuno.football.remote.data.CompetitionSeasonRemote
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class GetCompetitionRemote(

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
    val area: CompetitionAreaRemote?,

    @SerialName("currentSeason")
    val currentSeason: CompetitionSeasonRemote?,

    @SerialName("seasons")
    val seasons: List<CompetitionSeasonRemote>,

    @SerialName("lastUpdated")
    val lastUpdated: String?,
)
