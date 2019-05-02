package com.joandev.speedrunking.data.games.model

import org.junit.Test
import shouldBe

class GamesDataTest {

  val givenGamesDataWithThreeElements = GamesData(
    listOf(
      GameRemoteEntity(GameNames("Game 1"), GameAssets(Logo("logo 1")), "id 1"),
      GameRemoteEntity(GameNames("Game 2"), GameAssets(Logo("logo 2")), "id 2"),
      GameRemoteEntity(GameNames("Game 3"), GameAssets(Logo("logo 3")), "id 3")
    )
  )

  @Test
  fun `gamesData entity should mapToDomain`() {
    val gamesData = givenGamesDataWithThreeElements

    val domainEntity = gamesData.mapToDomain()

    domainEntity.size shouldBe 3
    domainEntity.forEachIndexed { index, game ->
      game.gameId shouldBe gamesData.gamesData[index].id
      game.logoUrl shouldBe gamesData.gamesData[index].assets.logo.uri
      game.name shouldBe gamesData.gamesData[index].name.international
    }
  }
}