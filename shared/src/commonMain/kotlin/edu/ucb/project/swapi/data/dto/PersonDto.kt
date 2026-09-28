package edu.ucb.project.swapi.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PersonDto(
    @SerialName("name") val name: String? = null,
    @SerialName("height") val height: String? = null,
    @SerialName("mass") val mass: String? = null,
    @SerialName("hair_color") val hairColor: String? = null,
    @SerialName("skin_color") val skinColor: String? = null,
    @SerialName("eye_color") val eyeColor: String? = null,
    @SerialName("gender") val gender: String? = null,
    @SerialName("url") val url: String? = null
)
