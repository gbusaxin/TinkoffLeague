package com.example.tinkoffleague.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tinkoffleague.R
import com.example.tinkoffleague.presentation.AppViewModel
import com.example.tinkoffleague.presentation.adapters.PlayerAdapter
import kotlinx.android.synthetic.main.fragment_player.*

class PlayerFragment : Fragment() {

    lateinit var viewModel:AppViewModel
    lateinit var adapter: PlayerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]
        adapter = PlayerAdapter()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_player, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val index = activity?.intent?.getIntExtra("teamItem", -1)

        viewModel.teamList.observe(viewLifecycleOwner, {
            if (index != null) {
                val team = it[index]
                val results = team.players
                if (results != null) {
                    adapter.list = results.toMutableList()
                    rvPlayer.adapter = adapter
                }
            }
        })

    }
}