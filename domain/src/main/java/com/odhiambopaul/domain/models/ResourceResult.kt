package com.odhiambopaul.domain.models

sealed class ResourceResult<T>(open val data: T? = null, open val message: String? = null) {
    data class Success<T>(override val data: T?) : ResourceResult<T>(data)
    data class Error<T>(
        override val message: String,
        override val data: T? = null,
        val networkError: Boolean = false
    ) : ResourceResult<T>(data, message)

    data class Loading<T>(val isLoading: Boolean = true) : ResourceResult<T>(null)
    data class Empty<T>(override val message: String) : ResourceResult<T>(null)
}