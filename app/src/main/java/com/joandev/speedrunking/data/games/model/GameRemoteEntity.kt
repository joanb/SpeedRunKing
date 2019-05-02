package com.joandev.speedrunking.data.games.model

import com.google.gson.annotations.SerializedName

class GameRemoteEntity(
  @SerializedName("names") val name: GameNames,
  @SerializedName("assets") val assets: GameAssets,
  @SerializedName("id") val id: String
)

class GameNames(@SerializedName("international") val international: String)
class GameAssets(@SerializedName("logo") val logo: Logo)
class Logo(@SerializedName("uri") val uri: String)
class GameLink(@SerializedName("rel") val type: String, @SerializedName("uri") val runsUri: String)