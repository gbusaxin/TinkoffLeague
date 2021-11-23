package com.example.tinkoffleague.presentation.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.tinkoffleague.R
import com.example.tinkoffleague.domain.pojo.ResultItem
import com.example.tinkoffleague.domain.pojo.TeamItem
import com.example.tinkoffleague.presentation.AppViewModel
import com.example.tinkoffleague.presentation.adapters.FixturesAdapter
import com.example.tinkoffleague.presentation.adapters.ResultsAdapter
import kotlinx.android.synthetic.main.fragment_fixtures.*
import kotlinx.android.synthetic.main.fragment_results.*

class ResultsFragment : Fragment() {

    private lateinit var viewModel: AppViewModel
    private lateinit var adapter: ResultsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]
        adapter = ResultsAdapter()
        return inflater.inflate(R.layout.fragment_results, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val index = activity?.intent?.getIntExtra("teamItem", -1)

        viewModel.teamList.observe(viewLifecycleOwner, {
            if (index != null) {
                val team = it[index]
                val results = team.results
                if (results != null) {
                    adapter.list = results.toMutableList()
                    rvResults.adapter = adapter
                }
            }
        })
    }
}