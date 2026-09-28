package edu.ucb.project.PruebasGenerales.domain.usecase

import edu.ucb.project.PruebasGenerales.domain.model.MovieInfoModel
import edu.ucb.project.PruebasGenerales.domain.repository.CatalogRepository

class GetMoviesUseCase(private val repository: CatalogRepository) {
    suspend operator fun invoke(): Result<List<MovieInfoModel>> {
        return repository.getMovies()
    }
}
