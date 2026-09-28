package edu.ucb.project.signin.presentation.state.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.ucb.project.signin.domain.usecase.LoginUseCase
import edu.ucb.project.signin.domain.vo.Password
import edu.ucb.project.signin.domain.vo.Username
import edu.ucb.project.signin.presentation.state.effects.LoginEffect
import edu.ucb.project.signin.presentation.state.events.LoginEvent
import edu.ucb.project.signin.presentation.state.state.LoginState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LoginViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(LoginState())
    val state: StateFlow<LoginState> = _state.asStateFlow()

    private val _effect = MutableSharedFlow<LoginEffect>()
    val effect: SharedFlow<LoginEffect> = _effect.asSharedFlow()

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.UsernameChanged -> {
                _state.update { it.copy(username = event.username, error = null) }
            }
            is LoginEvent.PasswordChanged -> {
                _state.update { it.copy(password = event.password, error = null) }
            }
            is LoginEvent.LoginClicked -> {
                login()
            }
            is LoginEvent.ForgotPasswordClicked -> {
                viewModelScope.launch {
                    _effect.emit(LoginEffect.NavigateToForgotPassword)
                }
            }
        }
    }

    private fun login() {
        val currentState = _state.value
        if (currentState.username.isBlank() || currentState.password.isBlank()) {
            _state.update { it.copy(error = "Username and password cannot be empty") }
            return
        }

        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val result = loginUseCase(
                    Username(currentState.username),
                    Password(currentState.password)
                )
                if (result != null) {
                    _effect.emit(LoginEffect.NavigateToHome)
                } else {
                    _state.update { it.copy(isLoading = false, error = "Invalid credentials") }
                    _effect.emit(LoginEffect.ShowError("Invalid credentials"))
                }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = e.message ?: "Unknown error") }
                _effect.emit(LoginEffect.ShowError(e.message ?: "Unknown error"))
            } finally {
                _state.update { it.copy(isLoading = false) }
            }
        }
    }
}
