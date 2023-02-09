package com.devtamuno.football.remote.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TeamRemote(

    @SerialName("id")
    val id: Long,

    @SerialName("name")
    val name: String,

    @SerialName("shortName")
    val shortName: String,

    @SerialName("tla")
    val tla: String,

    @SerialName("address")
    val address: String,

    @SerialName("website")
    val website: String,

    @SerialName("founded")
    val founded: Int?,

    @SerialName("clubColors")
    val clubColors: String,

    @SerialName("venue")
    val venue: String,

    @SerialName("area")
    val area: CompetitionAreaRemote,

    @SerialName("coach")
    val coach: CoachRemote,

    @SerialName("squad")
    val squad: List<PlayerRemote>,

    @SerialName("runningCompetitions")
    val runningCompetitions: List<CompetitionRemote>,
)
