package edu.ucb.project.swapi.data.service

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import edu.ucb.project.swapi.data.datasource.SwapiRemoteDataSource
import edu.ucb.project.swapi.data.dto.SwapiPeopleResponseDto

class SwapiService : SwapiRemoteDataSource {

    private val client = HttpClient {
        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
        }
    }

    override suspend fun getPeople(page: Int): SwapiPeopleResponseDto {
        return client.get("https://swapi.dev/api/people/?page=$page").body()
    }
}
