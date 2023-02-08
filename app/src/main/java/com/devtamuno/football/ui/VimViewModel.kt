package com.devtamuno.football.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devtamuno.football.remote.data.Resource
import com.devtamuno.football.remote.repository.FootballRemoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class VimViewModel @Inject constructor(
    private val repository: FootballRemoteRepository
) : ViewModel() {


    fun getFootballServices() {
        viewModelScope.launch {
            val result = repository.getAllCompetitions()
            when (result) {
                is Resource.Failure -> {
                    println("VimViewModelError" + result.exception)
                }
                is Resource.Success -> {
                    println("VimViewModelError" + result.result)
                }
            }
        }
    }
}