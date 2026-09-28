package edu.ucb.project.signin.domain.repository

import edu.ucb.project.signin.domain.vo.Password
import edu.ucb.project.signin.domain.vo.Username
import edu.ucb.project.signin.domain.model.LoginModel

interface LoginRepository {

    suspend fun login(
        username: Username,
        password: Password
    ): LoginModel?
}