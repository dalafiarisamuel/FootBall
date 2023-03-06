package com.devtamuno.domain.data

data class Team(

    val id: Long,

    val name: String,

    val shortName: String,

    val tla: String,

    val address: String?,

    val website: String?,

    val founded: Int?,

    val clubColors: String?,

    val venue: String?,

    val crest: String?,

    val area: CompetitionArea?,

    val coach: Coach?,

    val squad: List<Player>,

    val runningCompetitions: List<Competition>,
)
