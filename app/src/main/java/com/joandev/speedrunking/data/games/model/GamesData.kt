package com.joandev.speedrunking.data.games.model

import com.google.gson.annotations.SerializedName
import com.joandev.speedrunking.domain.games.model.Game

class GamesData(
  @SerializedName("data") val gamesData: List<GameRemoteEntity>
)

fun GamesData.mapToDomain(): List<Game> {
  return gamesData.map { gameData ->
    Game(
      gameData.name.international,
      gameData.assets.logo.uri,
      gameData.id
    )
  }
}