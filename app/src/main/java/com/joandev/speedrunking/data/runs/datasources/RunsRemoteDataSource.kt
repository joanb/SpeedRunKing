package com.joandev.speedrunking.data.runs.datasources

import com.joandev.speedrunking.data.runs.datasources.model.mapToDomain
import com.joandev.speedrunking.data.runs.datasources.remote.RunsApi
import com.joandev.speedrunking.domain.runs.model.GameRun
import io.reactivex.Single
import retrofit2.Retrofit

class RunsRemoteDataSource(private val retrofit: Retrofit) : RunsDataSource {

  override fun getBestGameRunById(runId: String): Single<GameRun> =
    retrofit.create(RunsApi::class.java)
      .getBestGameRunById(runId)
      .map { it.gamesData.sortedBy { it.runTime.timeInSeconds }.mapToDomain() }
}