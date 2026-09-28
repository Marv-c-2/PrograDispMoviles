package edu.ucb.project.signin.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import edu.ucb.project.signin.presentation.composable.LoginButton
import edu.ucb.project.signin.presentation.state.events.LoginEvent
import edu.ucb.project.signin.presentation.state.viewModel.LoginViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SigninPage(
    viewModel: LoginViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Sign In")
        
        OutlinedTextField(
            value = state.username,
            onValueChange = { viewModel.onEvent(LoginEvent.UsernameChanged(it)) },
            label = { Text("Username") },
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            singleLine = true
        )

        OutlinedTextField(
            value = state.password,
            onValueChange = { viewModel.onEvent(LoginEvent.PasswordChanged(it)) },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
            singleLine = true
        )

        if (state.error != null) {
            Text(
                text = state.error ?: "",
                color = Color.Red,
                modifier = Modifier.padding(vertical = 4.dp)
            )
        }

        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.padding(vertical = 8.dp))
        } else {
            LoginButton(
                onClick = { viewModel.onEvent(LoginEvent.LoginClicked) },
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}
