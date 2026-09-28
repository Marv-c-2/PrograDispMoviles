package edu.ucb.project.swapi.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.ucb.project.swapi.domain.model.PersonModel
import edu.ucb.project.swapi.presentation.state.SwapiEvent
import edu.ucb.project.swapi.presentation.viewModel.SwapiViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun SwapiScreen(viewModel: SwapiViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Título de la pantalla
        Text(
            text = "Personajes de Star Wars",
            style = MaterialTheme.typography.headlineMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Estado de Carga / Error / Lista
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            if (state.isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            } else if (state.error != null) {
                Text(
                    text = state.error ?: "Error al obtener datos",
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier.align(Alignment.Center)
                )
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    contentPadding = PaddingValues(bottom = 16.dp)
                ) {
                    items(state.people) { person ->
                        PersonCard(person = person)
                    }
                }
            }
        }

        // Botones de Paginación
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { viewModel.onEvent(SwapiEvent.PreviousPage) },
                enabled = state.hasPrevious && !state.isLoading
            ) {
                Text("Anterior")
            }

            Text(
                text = "Página ${state.currentPage}",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )

            Button(
                onClick = { viewModel.onEvent(SwapiEvent.NextPage) },
                enabled = state.hasNext && !state.isLoading
            ) {
                Text("Siguiente")
            }
        }
    }
}

@Composable
fun PersonCard(person: PersonModel) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = person.name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Altura: ${person.height}")
            Text(text = "Peso: ${person.mass}")
            Text(text = "Color de cabello: ${person.hairColor}")
            Text(text = "Color de piel: ${person.skinColor}")
            Text(text = "Color de ojos: ${person.eyeColor}")
            Text(text = "Género: ${person.gender}")
        }
    }
}
