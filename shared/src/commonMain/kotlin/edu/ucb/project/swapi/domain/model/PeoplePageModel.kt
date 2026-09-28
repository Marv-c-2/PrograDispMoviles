package edu.ucb.project.swapi.domain.model

data class PeoplePageModel(
    val count: Int,
    val hasNext: Boolean,
    val hasPrevious: Boolean,
    val currentPage: Int,
    val people: List<PersonModel>
)
