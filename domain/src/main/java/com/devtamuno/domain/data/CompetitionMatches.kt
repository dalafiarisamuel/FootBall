package com.devtamuno.domain.data

data class CompetitionMatches(

    val filters: Filters,

    val resultSet: ResultSet,

    val competition: Competition,

    val matches: List<Match>
)
