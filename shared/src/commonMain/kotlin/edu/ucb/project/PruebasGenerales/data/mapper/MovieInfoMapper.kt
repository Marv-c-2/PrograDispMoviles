package edu.ucb.project.PruebasGenerales.data.mapper

import edu.ucb.project.PruebasGenerales.data.dto.MovieInfoDto
import edu.ucb.project.PruebasGenerales.domain.model.MovieInfoModel

fun MovieInfoDto.toModel(): MovieInfoModel {
    return MovieInfoModel(title = title, posterPath = posterPath)
}
