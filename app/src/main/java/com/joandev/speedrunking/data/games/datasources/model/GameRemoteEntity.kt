package com.joandev.speedrunking.data.games.datasources.model

import com.google.gson.annotations.SerializedName

class GameRemoteEntity(
  @SerializedName("abbreviation") val abbreviation: String
)