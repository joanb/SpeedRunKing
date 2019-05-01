package com.joandev.speedrunking.domain.runs

import com.joandev.speedrunking.domain.UseCase
import com.joandev.speedrunking.domain.runs.model.GameRun
import io.reactivex.Scheduler
import io.reactivex.Single

class GetGameRunById(
  private val repository: RunsRepository,
  threadScheduler: Scheduler,
  postExecutionThread: Scheduler
) : UseCase<String, GameRun>(threadScheduler, postExecutionThread) {

  override fun buildUseCaseSingle(params: String): Single<GameRun> = repository.getRunById(params)
}