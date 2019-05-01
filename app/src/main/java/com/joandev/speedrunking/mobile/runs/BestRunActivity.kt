package com.joandev.speedrunking.mobile.runs

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.joandev.speedrunking.R
import com.joandev.speedrunking.domain.runs.model.GameRun
import com.joandev.speedrunking.mobile.extensions.load
import com.joandev.speedrunking.mobile.extensions.openUrlInBrowser
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.ext.android.inject

class BestRunActivity : AppCompatActivity(), BestRunPresenter.View {

  private val presenter: BestRunPresenter by inject()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_detail)

    presenter.attachView(this)
    presenter.onGameIdGathered(intent.extras.getString(GAME_ID_KEY))
  }

  override fun showGameData() {
    with(intent) {
      gameLogoImageView.load(getStringExtra(GAME_LOGO_URL_KEY))
      gameNameTextView.text = getStringExtra(GAME_NAME_KEY)
    }
  }

  override fun showRunData(gameRun: GameRun) {
    playerNameTextView.text = "Player: ${gameRun.playerName}"
    timeTextView.text = "${gameRun.runTime} seconds"
    videoButton.setOnClickListener { presenter.onVideoButtonClick(gameRun) }
  }

  override fun openUrl(videoUrl: String) {
    openUrlInBrowser(videoUrl)
  }

  override fun showLoading() {}
  override fun hideLoading() {}

  companion object {
    private const val GAME_ID_KEY = "game_id_key"
    private const val GAME_NAME_KEY = "hame_name_key"
    private const val GAME_LOGO_URL_KEY = "game_logo_url_key"

    fun getIntent(context: Context, runUrl: String, gameName: String, gameLogoUrl: String): Intent {
      return Intent(context, BestRunActivity::class.java).apply {
        putExtra(GAME_ID_KEY, runUrl)
        putExtra(GAME_NAME_KEY, gameName)
        putExtra(GAME_LOGO_URL_KEY, gameLogoUrl)
      }
    }
  }
}
