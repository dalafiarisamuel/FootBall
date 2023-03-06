package com.devtamuno.domain.data


data class Match(

    val id: Long,

    val utcDate: String,

    val status: String,

    val matchDay: Long,

    val stage: String,

    val lastUpdated: String,

    val area: CompetitionArea,

    val competition: Competition,

    val season: CompetitionSeason,

    val homeTeam: Team,

    val awayTeam: Team,

    val referees: List<Referee>,
)
