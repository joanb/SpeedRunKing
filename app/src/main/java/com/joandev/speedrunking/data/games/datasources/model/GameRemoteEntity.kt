package com.joandev.speedrunking.data.games.datasources.model

import com.google.gson.annotations.SerializedName

class GameRemoteEntity(
  @SerializedName("names") val gameName: GameNames,
  @SerializedName("assets") val gameAssets: GameAssets
)

class GameNames(@SerializedName("international") val name: String)
class GameAssets(@SerializedName("logo") val logo: Logo)
class Logo(@SerializedName("uri") val uri: String)