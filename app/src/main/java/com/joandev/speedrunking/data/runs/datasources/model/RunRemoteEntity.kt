package com.joandev.speedrunking.data.runs.datasources.model

import com.google.gson.annotations.SerializedName

class RunRemoteEntity(
  @SerializedName("videos") val videos: VideoRemoteEntity?,
  @SerializedName("players") val players: List<Player>,
  @SerializedName("times") val runTime: RunTime
  )

class VideoRemoteEntity(@SerializedName("links") val videoLinks: List<VideoLink>)
class VideoLink(@SerializedName("uri") val videoUrl: String)
class Player(@SerializedName("name") val name: String?)
class RunTime(@SerializedName("primary_t") val timeInSeconds: Int)