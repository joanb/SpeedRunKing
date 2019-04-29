package com.joandev.speedrunking.data.games.datasources.model

import com.google.gson.annotations.SerializedName
import com.joandev.speedrunking.domain.games.model.Game

class GamesData(
  @SerializedName("data") val gamesData: List<GameRemoteEntity>
)

fun GamesData.mapToDomain(): List<Game> {
  return gamesData.map { Game(it.name.international, it.assets.logo.uri, it.links.runUri) }
}