package com.example.tinkoffleague.presentation.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tinkoffleague.R
import com.example.tinkoffleague.domain.pojo.ResultInfo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.results_item.view.*

class ResultsAdapter : RecyclerView.Adapter<ResultsAdapter.ResultsViewHolder>() {

    inner class ResultsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imageResult = view.resultImage
        val nameResult = view.resultEnemy
        val typeResult = view.resultType
        val dateResult = view.resultDate
        val resultResult = view.resultResult
    }

    var list = mutableListOf<ResultInfo>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ResultsViewHolder {
        return ResultsViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.results_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ResultsViewHolder, position: Int) {
        var item = list[position]
        with(holder) {
            Picasso.get().load(item.imageURL).into(imageResult)
            nameResult.text = item.enemy
            typeResult.text = item.type
            dateResult.text = item.date
            resultResult.text = item.result
            when(item.status){
                1 -> resultResult.setTextColor(Color.GREEN)
                2 -> resultResult.setTextColor(Color.RED)
                3 -> resultResult.setTextColor(Color.YELLOW)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}