package com.joandev.speedrunking.data.games.datasources

import com.joandev.speedrunking.domain.games.model.Game
import io.reactivex.Single

interface GamesDataSource {
  fun getGames(): Single<List<Game>>
}