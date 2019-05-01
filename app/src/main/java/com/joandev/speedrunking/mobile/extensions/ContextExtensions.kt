package com.joandev.speedrunking.mobile.extensions

import android.content.Context
import android.content.Intent
import android.net.Uri


fun Context.openUrlInBrowser(url: String) {
  startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
}