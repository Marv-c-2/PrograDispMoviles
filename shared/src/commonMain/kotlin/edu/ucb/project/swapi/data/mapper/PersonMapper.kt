package edu.ucb.project.swapi.data.mapper

import edu.ucb.project.swapi.data.dto.PersonDto
import edu.ucb.project.swapi.data.dto.SwapiPeopleResponseDto
import edu.ucb.project.swapi.domain.model.PeoplePageModel
import edu.ucb.project.swapi.domain.model.PersonModel

fun PersonDto.toModel(): PersonModel {
    return PersonModel(
        name = name ?: "Desconocido",
        height = if (height != null && height != "unknown") "${height} cm" else "Desconocida",
        mass = if (mass != null && mass != "unknown") "${mass} kg" else "Desconocido",
        hairColor = hairColor?.capitalizeFirstLetter() ?: "N/A",
        skinColor = skinColor?.capitalizeFirstLetter() ?: "N/A",
        eyeColor = eyeColor?.capitalizeFirstLetter() ?: "N/A",
        gender = gender?.capitalizeFirstLetter() ?: "N/A",
        url = url ?: ""
    )
}

fun SwapiPeopleResponseDto.toModel(currentPage: Int): PeoplePageModel {
    return PeoplePageModel(
        count = count ?: 0,
        hasNext = next != null,
        hasPrevious = previous != null,
        currentPage = currentPage,
        people = results?.map { it.toModel() } ?: emptyList()
    )
}

private fun String.capitalizeFirstLetter(): String {
    if (isEmpty()) return this
    return replaceFirstChar { if (it.isLowerCase()) it.titlecase() else it.toString() }
}
