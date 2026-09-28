package edu.ucb.project.swapi.presentation.state

sealed interface SwapiEvent {
    data object NextPage : SwapiEvent
    data object PreviousPage : SwapiEvent
}
