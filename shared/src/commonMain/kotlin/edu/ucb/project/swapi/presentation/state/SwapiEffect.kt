package edu.ucb.project.swapi.presentation.state

sealed interface SwapiEffect {
    data class ShowToast(val message: String) : SwapiEffect
}
