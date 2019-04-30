package com.joandev.speedrunking.mobile.games.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.joandev.speedrunking.R
import com.joandev.speedrunking.domain.games.model.Game
import com.joandev.speedrunking.mobile.extensions.load
import kotlinx.android.synthetic.main.item_game.view.*

class GamesRecyclerViewAdapter(val onItemSelected: (Game) -> Unit) : RecyclerView.Adapter<GamesRecyclerViewAdapter.GamesViewHolder>() {

  var games: List<Game> = listOf()

  fun setItems(games: List<Game>) {
    this.games = games
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
    return GamesViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false), onItemSelected)
  }

  override fun getItemCount(): Int = games.count()

  override fun onBindViewHolder(viewHolder: GamesViewHolder, position: Int) {
    viewHolder.bind(games[position])
  }

  class GamesViewHolder(itemView: View, val onItemSelected: (Game) -> Unit) : RecyclerView.ViewHolder(itemView) {
    fun bind(game: Game) = with(itemView) {
      setOnClickListener { onItemSelected.invoke(game) }
      gameLogoImageView.load(game.logoUrl)
      gameNameTextView.text = game.name
    }
  }
}