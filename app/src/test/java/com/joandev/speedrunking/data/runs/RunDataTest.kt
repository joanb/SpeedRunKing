package com.joandev.speedrunking.data.runs

import com.joandev.speedrunking.data.runs.datasources.model.*
import org.junit.Test
import shouldBe

class RunDataTest {


  @Test
  fun `should return correct domain params when mapToDomain`() {
    val runsData = listOf(givenACorrectRunRemoteEntity())

    val domainRun = runsData.mapToDomain()

    domainRun.videoUrl shouldBe "url"
    domainRun.playerName shouldBe "playerName"
    domainRun.runTime shouldBe 230
  }

  @Test(expected = NoSuchElementException::class)
  fun `should throw exception when mapToDomain with no correct data`() {
    val runsData = listOf(
      givenAWrongRunRemoteEntityWithNoPlayerName(),
      givenAWrongRunRemoteEntityWithNoVideos()
    )

    val domainRun = runsData.mapToDomain()

    domainRun.runTime shouldBe null
    domainRun.playerName shouldBe null
    domainRun.videoUrl shouldBe null
  }

  @Test
  fun `should return first valid option`() {
    val runsData = listOf(
      givenACorrectRunRemoteEntity("2", "2", 2),
      givenACorrectRunRemoteEntity("1", "1", 1),
      givenACorrectRunRemoteEntity("3", "3", 3)
    )

    val domainRun = runsData.mapToDomain()

    domainRun.videoUrl shouldBe "2"
    domainRun.playerName shouldBe "2"
    domainRun.runTime shouldBe 2
  }

  @Test
  fun `should filter non valid data and return first valid`() {
    val runsData = listOf(
      givenAWrongRunRemoteEntityWithNoPlayerName(),
      givenAWrongRunRemoteEntityWithNoPlayerName(),
      givenACorrectRunRemoteEntity("1", "1", 1),
      givenACorrectRunRemoteEntity("2", "2", 2),
      givenACorrectRunRemoteEntity("3", "3", 3)
    )

    val domainRun = runsData.mapToDomain()

    domainRun.videoUrl shouldBe "1"
    domainRun.playerName shouldBe "1"
    domainRun.runTime shouldBe 1
  }

  fun givenACorrectRunRemoteEntity(
    videoURl: String = "url",
    playerName: String = "playerName",
    runTime: Int = 230
  ) =
    RunRemoteEntity(
      VideoRemoteEntity(listOf(VideoLink(videoURl))),
      listOf(Player(playerName)),
      RunTime(runTime)
    )

  fun givenAWrongRunRemoteEntityWithNoVideos() =
    RunRemoteEntity(
      null,
      listOf(Player("playerName")),
      RunTime(230)
    )

  fun givenAWrongRunRemoteEntityWithNoPlayerName() =
    RunRemoteEntity(
      VideoRemoteEntity(listOf(VideoLink("url"))),
      listOf(Player(null)),
      RunTime(230)
    )
}