package com.joandev.speedrunking.domain.games

import com.joandev.speedrunking.domain.UseCase
import com.joandev.speedrunking.domain.games.model.Game
import io.reactivex.Scheduler
import io.reactivex.Single

class GetGames(
  private val repository: GamesRepository,
  threadScheduler: Scheduler,
  postExecutionThread: Scheduler
) : UseCase<Unit?, List<Game>>(threadScheduler, postExecutionThread) {


  override fun buildUseCaseSingle(params: Unit?): Single<List<Game>> = repository.getGames()
}