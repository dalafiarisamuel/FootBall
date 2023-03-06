package com.devtamuno.domain.mapper

import com.devtamuno.domain.data.CompetitionArea
import com.devtamuno.football.remote.data.CompetitionAreaRemote
import javax.inject.Inject

class CompetitionAreaMapper @Inject constructor() : (CompetitionAreaRemote) -> CompetitionArea {

    override fun invoke(competitionAreaRemote: CompetitionAreaRemote): CompetitionArea {
        return with(competitionAreaRemote) {
            CompetitionArea(
                id, name, code, flag
            )
        }
    }
}