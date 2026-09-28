package edu.ucb.project.PruebasGenerales.domain.repository

import edu.ucb.project.PruebasGenerales.domain.model.MovieInfoModel

interface CatalogRepository {
    suspend fun getMovies(): Result<List<MovieInfoModel>>
}
