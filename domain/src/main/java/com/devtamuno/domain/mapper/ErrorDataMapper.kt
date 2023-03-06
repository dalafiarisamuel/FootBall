package com.devtamuno.domain.mapper

import com.devtamuno.domain.data.ErrorData
import com.devtamuno.football.remote.data.ErrorDataRemote
import javax.inject.Inject

class ErrorDataMapper @Inject constructor() : (ErrorDataRemote) -> ErrorData {
    override fun invoke(errorDateRemote: ErrorDataRemote): ErrorData {
        return with(errorDateRemote) {
            ErrorData(
                message,
            )
        }
    }
}