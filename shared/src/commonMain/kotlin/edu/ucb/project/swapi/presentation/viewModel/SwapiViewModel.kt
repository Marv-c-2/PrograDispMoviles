package edu.ucb.project.swapi.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.ucb.project.swapi.domain.usecase.GetPeopleUseCase
import edu.ucb.project.swapi.presentation.state.SwapiEvent
import edu.ucb.project.swapi.presentation.state.SwapiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SwapiViewModel(
    private val getPeopleUseCase: GetPeopleUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(SwapiState())
    val state = _state.asStateFlow()

    init {
        loadPage(1)
    }

    fun onEvent(event: SwapiEvent) {
        when (event) {
            SwapiEvent.NextPage -> {
                if (_state.value.hasNext && !_state.value.isLoading) {
                    loadPage(_state.value.currentPage + 1)
                }
            }
            SwapiEvent.PreviousPage -> {
                if (_state.value.hasPrevious && !_state.value.isLoading) {
                    loadPage(_state.value.currentPage - 1)
                }
            }
        }
    }

    private fun loadPage(page: Int) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }

            getPeopleUseCase(page)
                .onSuccess { pageModel ->
                    _state.update { currentState ->
                        currentState.copy(
                            isLoading = false,
                            people = pageModel.people,
                            currentPage = pageModel.currentPage,
                            hasNext = pageModel.hasNext,
                            hasPrevious = pageModel.hasPrevious,
                            error = null
                        )
                    }
                }
                .onFailure { throwable ->
                    _state.update { currentState ->
                        currentState.copy(
                            isLoading = false,
                            error = throwable.message ?: "Error al cargar personajes"
                        )
                    }
                }
        }
    }
}
