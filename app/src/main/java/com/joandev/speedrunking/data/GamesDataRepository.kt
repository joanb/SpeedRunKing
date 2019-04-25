package com.joandev.speedrunking.data

import com.joandev.speedrunking.data.datasources.GamesRemoteDataSource
import com.joandev.speedrunking.domain.games.GamesRepository
import com.joandev.speedrunking.domain.games.model.Game
import io.reactivex.Single

class GamesDataRepository(private val remoteDataSource: GamesRemoteDataSource): GamesRepository {

  override fun getGames(): Single<List<Game>> {
    return Single.error(RuntimeException())
  }
}