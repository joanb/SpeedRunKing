package com.joandev.speedrunking.data.runs.datasources.model

import com.google.gson.annotations.SerializedName
import com.joandev.speedrunking.domain.runs.model.GameRun

class RunData(
  @SerializedName("data") val gamesData: List<RunRemoteEntity>
)

fun RunData.mapToDomain() = GameRun()