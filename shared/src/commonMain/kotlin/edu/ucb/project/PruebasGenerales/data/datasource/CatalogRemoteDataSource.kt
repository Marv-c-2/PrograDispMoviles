package edu.ucb.project.PruebasGenerales.data.datasource

import edu.ucb.project.PruebasGenerales.domain.model.MovieInfoModel

interface CatalogRemoteDataSource {
    suspend fun fetchData(): Result<List<MovieInfoModel>>
}
