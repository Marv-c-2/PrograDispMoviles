package edu.ucb.project.swapi.domain.model

data class PersonModel(
    val name: String,
    val height: String,
    val mass: String,
    val hairColor: String,
    val skinColor: String,
    val eyeColor: String,
    val gender: String,
    val url: String = ""
)
