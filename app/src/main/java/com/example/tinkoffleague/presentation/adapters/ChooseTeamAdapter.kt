package com.example.tinkoffleague.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.tinkoffleague.R
import com.example.tinkoffleague.data.database.model.TeamInfoDbModel
import com.example.tinkoffleague.domain.pojo.TeamInfo
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.choose_team_item.view.*
import java.util.*
import kotlin.collections.ArrayList

class ChooseTeamAdapter(var teamList:ArrayList<TeamInfo>) :
    RecyclerView.Adapter<ChooseTeamAdapter.ChooseTeamViewHolder>(),
    Filterable {

    private var filteredList = ArrayList<TeamInfo>()
    init {
        filteredList = teamList as ArrayList<TeamInfo>
    }

    var onTeamClickListener: ((TeamInfo) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChooseTeamViewHolder {
        return ChooseTeamViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.choose_team_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ChooseTeamViewHolder, position: Int) {
        val item = filteredList[position]
        with(holder) {
            name.text = item.name
            Picasso.get().load(item.imageURL).into(image)
        }
        holder.itemView.setOnClickListener {
            onTeamClickListener?.invoke(item)
        }
    }

    override fun getItemCount(): Int {
        return filteredList.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): FilterResults {
                val charSearch = p0.toString()
                if (charSearch.isEmpty()) {
                    filteredList = teamList as ArrayList<TeamInfo>
                } else {
                    val resultList = ArrayList<TeamInfo>()
                    for (item in teamList) {
                        if (item.name.lowercase(Locale.ROOT)
                                .trim()
                                .contains(charSearch.lowercase(Locale.ROOT))
                        ) {
                            resultList.add(item)
                        }
                    }
                    filteredList = resultList
                }
                val filterResult = FilterResults()
                filterResult.values = filteredList
                return filterResult
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                filteredList = p1?.values as ArrayList<TeamInfo>
                notifyDataSetChanged()
            }
        }
    }

    inner class ChooseTeamViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val name = view.teamNameLabel
        val image = view.teamImageLabel

    }
}