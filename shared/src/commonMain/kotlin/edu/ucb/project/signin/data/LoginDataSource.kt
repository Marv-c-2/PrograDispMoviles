package edu.ucb.project.signin.data

import edu.ucb.project.signin.domain.vo.Password
import edu.ucb.project.signin.domain.vo.Username
import edu.ucb.project.signin.domain.model.LoginModel

class LoginDataSource {

    suspend fun login(
        username: Username,
        password: Password
    ): LoginModel? {

        if (username.value.isNotBlank() &&
            password.value.isNotBlank()
        ) {
            return LoginModel(username)
        }

        return null
    }
}