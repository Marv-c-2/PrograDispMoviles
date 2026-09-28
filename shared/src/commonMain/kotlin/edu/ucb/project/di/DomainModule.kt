package edu.ucb.project.di

import edu.ucb.project.signin.domain.usecase.LoginUseCase
import edu.ucb.project.PruebasGenerales.domain.usecase.GetMoviesUseCase
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val domainModule = module {

    singleOf(::LoginUseCase)
    singleOf(::GetMoviesUseCase)

}
