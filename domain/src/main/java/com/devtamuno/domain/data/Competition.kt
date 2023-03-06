package com.devtamuno.domain.data


data class Competition(

    val id: Long,

    val name: String,

    val code: String,

    val type: String,

    val emblem: String,

    val area: CompetitionArea?,

    val currentSeason: CompetitionSeason?,

    val numberOfAvailableSeason: Int?,

    val seasons: List<CompetitionSeason>,

    val lastUpdated: String?,
)
