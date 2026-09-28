package edu.ucb.project.PruebasGenerales.presentation.state.state

import edu.ucb.project.PruebasGenerales.domain.model.MovieInfoModel

data class CatalogState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val movies: List<MovieInfoModel> = emptyList()
)
