package com.joandev.speedrunking.data.games

import com.joandev.speedrunking.data.games.datasources.GamesDataSource
import com.joandev.speedrunking.domain.games.GamesRepository
import com.joandev.speedrunking.domain.games.model.Game
import io.reactivex.Single

class GamesDataRepository(private val remoteDataSource: GamesDataSource): GamesRepository {

  override fun getGames(): Single<List<Game>> {
    return remoteDataSource.getGames()
  }
}