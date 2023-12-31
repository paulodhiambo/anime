package com.odhiambopaul.data.network.util

import com.odhiambopaul.domain.models.DataResult
import io.ktor.client.call.*
import io.ktor.client.network.sockets.*
import io.ktor.client.plugins.*
import timber.log.Timber

@Deprecated("Use dataResultSafeApiCall")
suspend fun <T> safeApiCall(block: suspend () -> T): T {
    try {
        return block()
    } catch (e: Exception) {
        Timber.e(e)
        when (e) {
            is ServerResponseException, is NoTransformationFoundException -> {
                throw ServerError(e)
            }

            is ConnectTimeoutException -> {
                throw NetworkError()
            }

            else -> throw e
        }
    }
}

class ServerError(cause: Throwable) : Exception(cause)
class NetworkError : Exception()

suspend fun <T : Any> dataResultSafeApiCall(
    apiCall: suspend () -> T
): DataResult<T> = try {
    DataResult.Success(apiCall.invoke())
} catch (throwable: Throwable) {
    Timber.e(throwable)
    when (throwable) {
        is ServerResponseException, is NoTransformationFoundException -> {
            DataResult.Error("Server error", exc = throwable)
        }

        is ConnectTimeoutException -> {
            DataResult.Error("Network error", exc = throwable, networkError = true)
        }

        else -> {
            DataResult.Error("Client error", exc = throwable)
        }
    }
}