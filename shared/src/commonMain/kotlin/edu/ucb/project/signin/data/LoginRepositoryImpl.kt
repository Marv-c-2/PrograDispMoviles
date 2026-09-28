package edu.ucb.project.signin.data

import edu.ucb.project.signin.domain.vo.Password
import edu.ucb.project.signin.domain.vo.Username
import edu.ucb.project.signin.domain.model.LoginModel
import edu.ucb.project.signin.domain.repository.LoginRepository

class LoginRepositoryImpl(
    private val dataSource: LoginDataSource
) : LoginRepository {

    override suspend fun login(
        username: Username,
        password: Password
    ): LoginModel? {

        return dataSource.login(
            username,
            password
        )
    }
}