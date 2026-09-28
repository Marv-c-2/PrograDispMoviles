package edu.ucb.project.swapi.domain.repository

import edu.ucb.project.swapi.domain.model.PeoplePageModel

interface SwapiRepository {
    suspend fun getPeople(page: Int): Result<PeoplePageModel>
}
