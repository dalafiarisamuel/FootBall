package com.devtamuno.domain.mapper

import com.devtamuno.domain.data.ResultSet
import com.devtamuno.football.remote.data.ResultSetRemote
import javax.inject.Inject

class ResultSetMapper @Inject constructor() : (ResultSetRemote) -> ResultSet {
    override fun invoke(resultSetRemote: ResultSetRemote): ResultSet {
        return with(resultSetRemote) {
            ResultSet(
                count,
                firstGamePlayDate,
                lastGamePlayDate,
                played
            )
        }
    }
}