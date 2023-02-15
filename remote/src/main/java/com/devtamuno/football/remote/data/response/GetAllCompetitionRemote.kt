package com.devtamuno.football.remote.data.response

import com.devtamuno.football.remote.data.CompetitionRemote
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class GetAllCompetitionRemote(
    @SerialName("count")
    val count: Long,

    @SerialName("competitions")
    val competitions: List<CompetitionRemote>
)
