package com.example.tinkoffleague.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tinkoffleague.R
import com.example.tinkoffleague.domain.pojo.TeamItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.choose_team_item.view.*

class ChooseTeamAdapter:RecyclerView.Adapter<ChooseTeamAdapter.ChooseTeamViewHolder>() {

    var list = listOf<TeamItem>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    var onTeamClickListener :((TeamItem)-> Unit)?=null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChooseTeamViewHolder {
        return ChooseTeamViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.choose_team_item,parent,false))
    }

    override fun onBindViewHolder(holder: ChooseTeamViewHolder, position: Int) {
        var item = list[position]
        with(holder){
            name.text = item.name
            Picasso.get().load(item.imageURL).into(image)
        }
        holder.itemView.setOnClickListener{
            onTeamClickListener?.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ChooseTeamViewHolder(view:View): RecyclerView.ViewHolder(view) {

        val name = view.teamNameLabel
        val image = view.teamImageLabel

//        init{
//            view.setOnClickListener {
//                onTeamClickListener?.invoke(list[adapterPosition])
//            }
//        }

    }
}