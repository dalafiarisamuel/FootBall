package com.devtamuno.football.remote.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MatchRemote(
    @SerialName("id")
    val id: Long,

    @SerialName("utcDate")
    val utcDate: String,

    @SerialName("status")
    val status: String,

    @SerialName("matchday")
    val matchDay: Long,

    @SerialName("stage")
    val stage: String,

    @SerialName("lastUpdated")
    val lastUpdated: String,

    @SerialName("area")
    val area: CompetitionAreaRemote,

    @SerialName("competition")
    val competition: CompetitionRemote,

    @SerialName("season")
    val season: CompetitionSeasonRemote,

    @SerialName("homeTeam")
    val homeTeam: TeamRemote,

    @SerialName("awayTeam")
    val awayTeam: TeamRemote,

    @SerialName("referees")
    val referees: List<RefereeRemote>,

)
