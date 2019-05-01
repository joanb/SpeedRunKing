package com.joandev.speedrunking.data.runs.datasources

import com.joandev.speedrunking.domain.runs.model.GameRun
import io.reactivex.Single

interface RunsDataSource {

  fun getBestGameRunById(runId: String): Single<GameRun>
}