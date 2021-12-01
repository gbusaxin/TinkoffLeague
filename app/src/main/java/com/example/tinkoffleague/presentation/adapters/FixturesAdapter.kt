package com.example.tinkoffleague.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tinkoffleague.R
import com.example.tinkoffleague.domain.pojo.FixturesInfo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fixtures_item.view.*

class FixturesAdapter:RecyclerView.Adapter<FixturesAdapter.FixturesViewHolder>() {

    var list = mutableListOf<FixturesInfo>()
    set(value) {
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FixturesViewHolder {
        return FixturesViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.fixtures_item,parent,false))
    }

    override fun onBindViewHolder(holder: FixturesViewHolder, position: Int) {
        val item = list[position]
        with(holder){
            Picasso.get().load(item.imageURL).into(enemyImage)
            enemyName.text = item.enemy
            enemyType.text = item.type
            enemyDate.text = item.date
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class FixturesViewHolder(view: View):RecyclerView.ViewHolder(view){
        val enemyName = view.fixturesEnemy
        val enemyImage = view.fixturesImage
        val enemyType = view.fixturesType
        val enemyDate = view.fixturesDate
    }
}