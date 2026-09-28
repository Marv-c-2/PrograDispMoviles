package edu.ucb.project.di

import edu.ucb.project.signin.data.LoginDataSource
import edu.ucb.project.signin.data.LoginRepositoryImpl
import edu.ucb.project.signin.domain.repository.LoginRepository
import edu.ucb.project.PruebasGenerales.data.datasource.CatalogRemoteDataSource
import edu.ucb.project.PruebasGenerales.data.repository.CatalogRepositoryImpl
import edu.ucb.project.PruebasGenerales.data.service.CatalogService
import edu.ucb.project.PruebasGenerales.domain.repository.CatalogRepository
import edu.ucb.project.swapi.data.datasource.SwapiRemoteDataSource
import edu.ucb.project.swapi.data.repository.SwapiRepositoryImpl
import edu.ucb.project.swapi.data.service.SwapiService
import edu.ucb.project.swapi.domain.repository.SwapiRepository
import org.koin.dsl.module

val dataModule = module {

    single { LoginDataSource() }

    single<LoginRepository> {
        LoginRepositoryImpl(get())
    }

    single<CatalogRemoteDataSource> { CatalogService() }

    single<CatalogRepository> {
        CatalogRepositoryImpl(get())
    }

    single<SwapiRemoteDataSource> { SwapiService() }

    single<SwapiRepository> {
        SwapiRepositoryImpl(get())
    }
}
