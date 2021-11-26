package com.example.tinkoffleague.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tinkoffleague.R
import com.example.tinkoffleague.domain.pojo.TournamentItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.tournament_item.view.*

class TournamentAdapter : RecyclerView.Adapter<TournamentAdapter.TournamentViewHolder>(){

    inner class TournamentViewHolder(view:View):RecyclerView.ViewHolder(view){

        val tournamentPosition = view.tournamentPosition
        val tournamentImage = view.tournamentImage
        val tournamentName = view.tournamentName
        val tournamenN = view.tournamentN
        val tournamenB = view.tournamentB
        val tournamenH = view.tournamentH
        val tournamenP = view.tournamentP
        val tournamenZ_P = view.tournamentZ_P
        val tournamenScores = view.tournamentScores

    }

    var list= listOf<TournamentItem>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TournamentViewHolder {
        return TournamentViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.tournament_item,parent,false))
    }

    override fun onBindViewHolder(holder: TournamentViewHolder, position: Int) {
        val item = list[position]
        with(holder){
            tournamentPosition.text = item.teamPosition.toString()
            Picasso.get().load(item.teamImage).into(tournamentImage)
            tournamentName.text = item.teamName
            tournamenN.text = item.n.toString()
            tournamenB.text = item.b.toString()
            tournamenH.text = item.h.toString()
            tournamenP.text = item.p.toString()
            tournamenZ_P.text = item.zP
            tournamenScores.text = item.scores.toString()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}