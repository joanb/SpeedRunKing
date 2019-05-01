package com.joandev.speedrunking.data.runs.datasources.model

import com.google.gson.annotations.SerializedName
import com.joandev.speedrunking.domain.runs.model.GameRun

class RunData(
  @SerializedName("data") val gamesData: List<RunRemoteEntity>
)

fun List<RunRemoteEntity>.mapToDomain(): GameRun =
  with(first { it.players.first().name != null && it.videos != null }) {
    GameRun(players.first().name, runTime.timeInSeconds, videos!!.videoLinks.first().videoUrl)
  }