package edu.ucb.project.PruebasGenerales.data.repository

import edu.ucb.project.PruebasGenerales.data.datasource.CatalogRemoteDataSource
import edu.ucb.project.PruebasGenerales.domain.model.MovieInfoModel
import edu.ucb.project.PruebasGenerales.domain.repository.CatalogRepository

class CatalogRepositoryImpl(val dataSource: CatalogRemoteDataSource) : CatalogRepository {

    override suspend fun getMovies(): Result<List<MovieInfoModel>> {
        return dataSource.fetchData()
    }
}
