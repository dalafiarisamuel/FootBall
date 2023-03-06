package com.devtamuno.domain.mapper

import com.devtamuno.domain.data.Filters
import com.devtamuno.football.remote.data.FiltersRemote
import javax.inject.Inject

class FiltersMapper @Inject constructor() : (FiltersRemote) -> Filters {

    override fun invoke(filterRemote: FiltersRemote): Filters {
        return with(filterRemote) {
            Filters(season)
        }
    }
}