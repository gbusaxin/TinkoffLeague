package com.example.tinkoffleague.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tinkoffleague.R
import com.example.tinkoffleague.presentation.ViewModelApp
import com.example.tinkoffleague.presentation.adapters.TournamentAdapter
import kotlinx.android.synthetic.main.fragment_tournament.*

class TournamentFragment : Fragment() {

    lateinit var viewModel:ViewModelApp
    lateinit var adapter:TournamentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[ViewModelApp::class.java]
        adapter = TournamentAdapter()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tournament, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.tournamentList.observe(viewLifecycleOwner,{
            Log.d("TOURNAMENT_FRAG",it.toString())
            adapter.list = it
            rvTournament.adapter = adapter
        })


    }
}