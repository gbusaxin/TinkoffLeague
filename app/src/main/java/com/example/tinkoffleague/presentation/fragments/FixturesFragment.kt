package com.example.tinkoffleague.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tinkoffleague.R
import com.example.tinkoffleague.presentation.AppViewModel
import com.example.tinkoffleague.presentation.adapters.FixturesAdapter
import kotlinx.android.synthetic.main.fragment_fixtures.*

class FixturesFragment : Fragment() {

    private lateinit var viewModel: AppViewModel
    private lateinit var adapter: FixturesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fixtures, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]
        adapter = FixturesAdapter()

        val index = activity?.intent?.getIntExtra("teamItem",-1)
        viewModel.liveDataFixturesInfo.observe(viewLifecycleOwner, {
            if (index != null){
                val fixtures = it[index]
                if (fixtures != null) {
                    adapter.list = fixtures
                    rvFixtures.adapter = adapter
                }
            }
        })
    }
}