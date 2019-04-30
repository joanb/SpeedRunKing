package com.joandev.speedrunking.data.runs

import com.joandev.speedrunking.data.runs.datasources.RunsDataSource
import com.joandev.speedrunking.domain.runs.RunsRepository
import com.joandev.speedrunking.domain.runs.model.GameRun
import io.reactivex.Single

class RunsDataRepository(private val remoteDataSource: RunsDataSource) : RunsRepository {

  override fun getRunById(runId: String): Single<GameRun> {
    return remoteDataSource.getRunById(runId)
  }
}