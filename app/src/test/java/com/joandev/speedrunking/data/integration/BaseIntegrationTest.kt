package com.joandev.speedrunking.data.integration

import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

open class BaseIntegrationTest {

  private val mockWebServer = MockWebServer()
  protected lateinit var retrofit: Retrofit

  @Before
  open fun setUp() {
    mockWebServer.start()
    retrofit = Retrofit.Builder()
      .baseUrl(mockWebServer.url("/")) // Other builder methods.
      .addConverterFactory(GsonConverterFactory.create())
      .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
      .build()
  }

  @After
  fun finalize() {
    mockWebServer.shutdown()
  }

  fun enqueueResponse(code: Int, body: String? = null) {
    mockWebServer.enqueue(MockResponse().apply {
      setResponseCode(code)
      body?.let { setBody(it) }
    })
  }
}
