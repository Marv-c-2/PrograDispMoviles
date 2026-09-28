package edu.ucb.project.swapi.domain.usecase

import edu.ucb.project.swapi.domain.model.PeoplePageModel
import edu.ucb.project.swapi.domain.repository.SwapiRepository

class GetPeopleUseCase(private val repository: SwapiRepository) {
    suspend operator fun invoke(page: Int = 1): Result<PeoplePageModel> {
        return repository.getPeople(page)
    }
}
