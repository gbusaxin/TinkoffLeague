package com.example.tinkoffleague.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tinkoffleague.R
import com.example.tinkoffleague.domain.pojo.PlayerItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.player_item.view.*

class PlayerAdapter:RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {
    inner class PlayerViewHolder(view: View):RecyclerView.ViewHolder(view){
        val playerName = view.playerName
        val playerImage = view.playerImage
        val playerPosition = view.playerPosition
    }

    var list = mutableListOf<PlayerItem>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        return PlayerViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.player_item,parent,false))
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        var item = list[position]
        with(holder){
            Picasso.get().load(item.imagePlayer).into(playerImage)
            playerName.text = item.name
            playerPosition.text = item.position
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}