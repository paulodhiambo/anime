package com.odhiambopaul.data.network.apis

import com.odhiambopaul.data.network.Constants.BASE_URL
import com.odhiambopaul.data.network.model.responses.PaginatedResponse
import com.odhiambopaul.data.network.util.dataResultSafeApiCall
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class AnimeApi @Inject constructor(private val client: HttpClient) {

    suspend fun fetchTopAnime(page: Int = 1, size: Int = 100) = dataResultSafeApiCall {
        val response: PaginatedResponse =
            client.get(BASE_URL) {
                url {
                    parameters.append("page", page.toString())
                    parameters.append("limit", size.toString())
                }
            }.body()

        return@dataResultSafeApiCall response.data
    }
}