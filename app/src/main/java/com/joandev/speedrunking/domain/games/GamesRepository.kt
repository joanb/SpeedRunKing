package com.joandev.speedrunking.domain.games

import com.joandev.speedrunking.domain.games.model.Game
import io.reactivex.Single

interface GamesRepository {
    fun getGames(): Single<List<Game>>
}