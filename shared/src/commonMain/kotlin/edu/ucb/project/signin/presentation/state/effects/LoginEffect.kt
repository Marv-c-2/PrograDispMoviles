package edu.ucb.project.signin.presentation.state.effects

sealed class LoginEffect {

    data object NavigateToHome : LoginEffect()

    data object NavigateToForgotPassword : LoginEffect()

    data class ShowError(
        val message: String
    ) : LoginEffect()
}