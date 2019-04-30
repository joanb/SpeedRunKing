package com.joandev.speedrunking.domain.runs

import com.joandev.speedrunking.domain.runs.model.GameRun
import io.reactivex.Single

interface RunsRepository {
  fun getRunById(runId: String): Single<GameRun>
}