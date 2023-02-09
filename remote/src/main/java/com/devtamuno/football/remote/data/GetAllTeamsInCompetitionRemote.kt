package com.devtamuno.football.remote.data

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class GetAllTeamsInCompetitionRemote(

    @SerialName("competition")
    val competition: CompetitionRemote,

    @SerialName("season")
    val season: CompetitionSeasonRemote,

    @SerialName("teams")
    val teams: List<TeamRemote>,
)
