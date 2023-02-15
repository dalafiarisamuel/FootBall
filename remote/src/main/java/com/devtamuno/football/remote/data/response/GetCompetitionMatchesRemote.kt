package com.devtamuno.football.remote.data.response

import com.devtamuno.football.remote.data.CompetitionRemote
import com.devtamuno.football.remote.data.FiltersRemote
import com.devtamuno.football.remote.data.MatchRemote
import com.devtamuno.football.remote.data.ResultSetRemote
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class GetCompetitionMatchesRemote(
    @SerialName("filters")
    val filters: FiltersRemote,

    @SerialName("resultSet")
    val resultSet: ResultSetRemote,

    @SerialName("competition")
    val competition: CompetitionRemote,

    @SerialName("matches")
    val matches: List<MatchRemote>
)
