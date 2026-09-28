package edu.ucb.project.swapi.presentation.state

import edu.ucb.project.swapi.domain.model.PersonModel

data class SwapiState(
    val isLoading: Boolean = false,
    val people: List<PersonModel> = emptyList(),
    val currentPage: Int = 1,
    val hasNext: Boolean = false,
    val hasPrevious: Boolean = false,
    val error: String? = null
)
