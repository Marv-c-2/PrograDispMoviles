package edu.ucb.project.signin.domain.usecase

import edu.ucb.project.signin.domain.vo.Password
import edu.ucb.project.signin.domain.vo.Username
import edu.ucb.project.signin.domain.model.LoginModel
import edu.ucb.project.signin.domain.repository.LoginRepository

class LoginUseCase(
    private val repository: LoginRepository
) {

    suspend operator fun invoke(
        username: Username,
        password: Password
    ): LoginModel? {
        return repository.login(username, password)
    }
}