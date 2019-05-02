package com.joandev.speedrunking.data.integration

import com.joandev.speedrunking.data.runs.RunsDataRepository
import com.joandev.speedrunking.data.runs.datasources.RunsRemoteDataSource
import com.joandev.speedrunking.domain.runs.GetBestGameRunById
import com.joandev.speedrunking.domain.runs.model.GameRun
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import shouldBe

class GetBestGameRunIntgrationTest : BaseIntegrationTest() {

  lateinit var getBestGameRunById: GetBestGameRunById

  @Before
  fun setup() {
    getBestGameRunById = GetBestGameRunById(
      RunsDataRepository(RunsRemoteDataSource(retrofit)),
      Schedulers.trampoline(),
      Schedulers.trampoline()
    )
  }

  @Test
  fun `should return correct object when data is valid`() {
    enqueueResponse(200, givenARunsJsonResponse("name"))

    val testObserver: TestObserver<GameRun> = getBestGameRunById.execute("fishy").test()
    testObserver.awaitTerminalEvent()

    testObserver.assertValueCount(1)
    testObserver.assertValue { it.playerName == "mkj9nw84" && it.runTime == 435 && it.videoUrl == "https://youtu.be/-Vesbd8uJzE" }

  }

  @Test
  fun `should return error when data is not valid`() {
    enqueueResponse(200, givenARunsJsonResponse())

    val testObserver: TestObserver<GameRun> = getBestGameRunById.execute("fishy").test()

    testObserver.errorCount() shouldBe 1
    testObserver.assertError(NoSuchElementException::class.java)
  }

  fun givenARunsJsonResponse(field: String = "id") = "{  \n" +
          "   \"data\":[  \n" +
          "      {  \n" +
          "         \"id\":\"7z0nvdem\",\n" +
          "         \"weblink\":\"https://www.speedrun.com/fishy/run/7z0nvdem\",\n" +
          "         \"game\":\"k6qqkx6g\",\n" +
          "         \"level\":null,\n" +
          "         \"category\":\"rklgq3rd\",\n" +
          "         \"videos\":{  \n" +
          "            \"links\":[  \n" +
          "               {  \n" +
          "                  \"uri\":\"https://youtu.be/-Vesbd8uJzE\"\n" +
          "               }\n" +
          "            ]\n" +
          "         },\n" +
          "         \"comment\":null,\n" +
          "         \"status\":{  \n" +
          "            \"status\":\"verified\",\n" +
          "            \"examiner\":\"mkj9nw84\",\n" +
          "            \"verify-date\":\"2016-05-29T00:31:08Z\"\n" +
          "         },\n" +
          "         \"players\":[  \n" +
          "            {  \n" +
          "               \"rel\":\"user\",\n" +
          "               \"$field\":\"mkj9nw84\",\n" +
          "               \"uri\":\"https://www.speedrun.com/api/v1/users/mkj9nw84\"\n" +
          "            }\n" +
          "         ],\n" +
          "         \"date\":\"2016-05-24\",\n" +
          "         \"submitted\":\"2016-05-29T00:31:08Z\",\n" +
          "         \"times\":{  \n" +
          "            \"primary\":\"PT7M15S\",\n" +
          "            \"primary_t\":435,\n" +
          "            \"realtime\":\"PT7M15S\",\n" +
          "            \"realtime_t\":435,\n" +
          "            \"realtime_noloads\":null,\n" +
          "            \"realtime_noloads_t\":0,\n" +
          "            \"ingame\":null,\n" +
          "            \"ingame_t\":0\n" +
          "         },\n" +
          "         \"system\":{  \n" +
          "            \"platform\":\"o7e25xew\",\n" +
          "            \"emulated\":false,\n" +
          "            \"region\":null\n" +
          "         },\n" +
          "         \"splits\":null,\n" +
          "         \"values\":{  \n" +
          "\n" +
          "         },\n" +
          "         \"links\":[  \n" +
          "            {  \n" +
          "               \"rel\":\"self\",\n" +
          "               \"uri\":\"https://www.speedrun.com/api/v1/runs/7z0nvdem\"\n" +
          "            },\n" +
          "            {  \n" +
          "               \"rel\":\"game\",\n" +
          "               \"uri\":\"https://www.speedrun.com/api/v1/games/k6qqkx6g\"\n" +
          "            },\n" +
          "            {  \n" +
          "               \"rel\":\"category\",\n" +
          "               \"uri\":\"https://www.speedrun.com/api/v1/categories/rklgq3rd\"\n" +
          "            },\n" +
          "            {  \n" +
          "               \"rel\":\"platform\",\n" +
          "               \"uri\":\"https://www.speedrun.com/api/v1/platforms/o7e25xew\"\n" +
          "            },\n" +
          "            {  \n" +
          "               \"rel\":\"examiner\",\n" +
          "               \"uri\":\"https://www.speedrun.com/api/v1/users/mkj9nw84\"\n" +
          "            }\n" +
          "         ]\n" +
          "      }" +
          "   ]" +
          "}"
}