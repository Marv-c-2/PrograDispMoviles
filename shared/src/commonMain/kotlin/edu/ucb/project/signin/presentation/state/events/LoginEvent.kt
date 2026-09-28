package edu.ucb.project.signin.presentation.state.events

sealed class LoginEvent {

    data class UsernameChanged(
        val username: String
    ) : LoginEvent()

    data class PasswordChanged(
        val password: String
    ) : LoginEvent()

    data object LoginClicked : LoginEvent()

    data object ForgotPasswordClicked : LoginEvent()
}