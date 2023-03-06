package com.devtamuno.domain.data


data class AllTeamsInCompetition(

    val competition: Competition,

    val season: CompetitionSeason,

    val teams: List<Team>,
)
