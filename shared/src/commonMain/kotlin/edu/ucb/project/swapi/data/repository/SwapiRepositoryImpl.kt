package edu.ucb.project.swapi.data.repository

import edu.ucb.project.swapi.data.datasource.SwapiRemoteDataSource
import edu.ucb.project.swapi.data.mapper.toModel
import edu.ucb.project.swapi.domain.model.PeoplePageModel
import edu.ucb.project.swapi.domain.repository.SwapiRepository

class SwapiRepositoryImpl(
    private val remoteDataSource: SwapiRemoteDataSource
) : SwapiRepository {

    override suspend fun getPeople(page: Int): Result<PeoplePageModel> {
        return try {
            val responseDto = remoteDataSource.getPeople(page)
            Result.success(responseDto.toModel(currentPage = page))
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
