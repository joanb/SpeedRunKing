package com.joandev.speedrunking.data.games

import com.joandev.speedrunking.data.games.datasources.remote.GamesRemoteDataSource
import com.joandev.speedrunking.domain.games.model.Game
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import shouldBe

class GamesDataRepositoryTest {


  @Mock
  lateinit var remoteDataSource: GamesRemoteDataSource
  @InjectMocks
  lateinit var gamesRepository: GamesDataRepository

  @Before
  fun init() {
    MockitoAnnotations.initMocks(this)
  }

  @Test
  fun `should return the result of remoteDataSource getGames()`() {
    val streamToReturn: Single<List<Game>> = Single.just(listOf())
    whenever(remoteDataSource.getGames()).thenReturn(streamToReturn)

    val streamReturned = gamesRepository.getGames()

    verify(remoteDataSource).getGames()
    streamReturned shouldBe streamToReturn
  }
}