package edu.ucb.project.swapi.data.datasource

import edu.ucb.project.swapi.data.dto.SwapiPeopleResponseDto

interface SwapiRemoteDataSource {
    suspend fun getPeople(page: Int): SwapiPeopleResponseDto
}
