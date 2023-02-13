package com.devtamuno.football.remote.data

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class WinnerRemote(

    @SerialName("id")
    val id: Int,

    @SerialName("name")
    val name: String,

    @SerialName("shortName")
    val shortName: String,

    @SerialName("tla")
    val tla: String,

    @SerialName("crest")
    val crest: String,

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

    @SerialName("lastUpdated")
    val lastUpdated: String
)
