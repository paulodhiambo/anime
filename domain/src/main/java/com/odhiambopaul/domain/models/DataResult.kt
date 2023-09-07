package com.odhiambopaul.domain.models

sealed interface DataResult<out T : Any> {
    data class Success<out T : Any>(val data: T) : DataResult<T>
    data class Error(
        val message: String,
        val networkError: Boolean = false,
        val exc: Throwable? = null
    ) : DataResult<Nothing>

    data class Loading<out T : Any>(val data: T?) : DataResult<T>
    object Empty : DataResult<Nothing>
}