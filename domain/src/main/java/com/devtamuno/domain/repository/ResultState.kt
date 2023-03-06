package com.devtamuno.domain.repository

sealed class ResultState<out R> {
    data class Success<out R>(val result: R) : ResultState<R>()
    data class Failure(val message: String) : ResultState<Nothing>()
}
