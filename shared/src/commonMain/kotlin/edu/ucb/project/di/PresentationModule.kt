package edu.ucb.project.di

import edu.ucb.project.signin.presentation.state.viewModel.LoginViewModel
import edu.ucb.project.PruebasGenerales.presentation.state.viewModel.CatalogViewModel
import edu.ucb.project.swapi.presentation.viewModel.SwapiViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {

    viewModelOf(::LoginViewModel)
    viewModelOf(::CatalogViewModel)
    viewModelOf(::SwapiViewModel)

}
