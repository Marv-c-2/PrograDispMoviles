package edu.ucb.project.di

import edu.ucb.project.signin.data.LoginDataSource
import edu.ucb.project.signin.data.LoginRepositoryImpl
import edu.ucb.project.signin.domain.repository.LoginRepository
import edu.ucb.project.PruebasGenerales.data.datasource.CatalogRemoteDataSource
import edu.ucb.project.PruebasGenerales.data.repository.CatalogRepositoryImpl
import edu.ucb.project.PruebasGenerales.data.service.CatalogService
import edu.ucb.project.PruebasGenerales.domain.repository.CatalogRepository
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
}
