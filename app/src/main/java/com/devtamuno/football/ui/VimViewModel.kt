package com.devtamuno.football.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devtamuno.domain.repository.FootballRepository
import com.devtamuno.domain.repository.ResultState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@HiltViewModel
class VimViewModel @Inject constructor(
    private val repository: FootballRepository
) : ViewModel() {


    fun getFootballServices() {
        repository
            .getAllMatchesInCompetition("PL")
            .onEach {
                when (it) {
                    is ResultState.Failure -> {
                        println("VimViewModelError" + it.message)
                    }
                    is ResultState.Success -> {
                        println("VimViewModelSuccess" + it.result)
                    }
                }
            }
            .launchIn(viewModelScope)
    }
}