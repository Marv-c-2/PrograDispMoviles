package edu.ucb.project.PruebasGenerales.presentation.state.events

sealed interface CatalogEvent {
    object OnBack : CatalogEvent
    object OnSubmit : CatalogEvent
}
