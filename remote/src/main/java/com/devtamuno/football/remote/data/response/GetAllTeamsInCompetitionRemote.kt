package com.devtamuno.football.remote.data.response

import com.devtamuno.football.remote.data.CompetitionRemote
import com.devtamuno.football.remote.data.CompetitionSeasonRemote
import com.devtamuno.football.remote.data.TeamRemote
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
