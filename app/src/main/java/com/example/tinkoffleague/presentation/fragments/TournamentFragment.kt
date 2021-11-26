package com.example.tinkoffleague.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.tinkoffleague.R
import com.example.tinkoffleague.presentation.AppViewModel
import com.example.tinkoffleague.presentation.adapters.TournamentAdapter
import kotlinx.android.synthetic.main.fragment_tournament.*

class TournamentFragment : Fragment() {

    lateinit var viewModel:AppViewModel
    lateinit var adapter:TournamentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]
        adapter = TournamentAdapter()
        if (viewModel.liveDataTournamentInfo.value == null) {
            viewModel.loadTournamentJson()
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tournament, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.liveDataTournamentInfo.observe(viewLifecycleOwner,{
            adapter.list = it
            rvTournament.adapter = adapter
        })


    }
}