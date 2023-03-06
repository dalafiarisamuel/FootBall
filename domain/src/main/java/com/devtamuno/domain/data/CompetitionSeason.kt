package com.devtamuno.domain.data

data class CompetitionSeason(

    val id: Int,

    val startDate: String,

    val endDate: String,

    val currentMatchDay: Int?,

    val winner: Winner?
)
