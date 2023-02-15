package com.devtamuno.football.remote.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FiltersRemote(

    @SerialName("season")
    val season: String
)
