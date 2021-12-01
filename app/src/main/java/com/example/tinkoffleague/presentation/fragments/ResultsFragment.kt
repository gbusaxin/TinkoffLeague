package com.example.tinkoffleague.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.tinkoffleague.R
import com.example.tinkoffleague.presentation.AppViewModel
import com.example.tinkoffleague.presentation.ViewModelApp
import com.example.tinkoffleague.presentation.adapters.ResultsAdapter
import kotlinx.android.synthetic.main.fragment_results.*

class ResultsFragment : Fragment() {

    private lateinit var viewModel: ViewModelApp
    private lateinit var adapter: ResultsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[ViewModelApp::class.java]
        adapter = ResultsAdapter()
        return inflater.inflate(R.layout.fragment_results, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val index = activity?.intent?.getStringExtra("teamItem")

        if (index != null) {
            viewModel.getTeamInfo(index).observe(viewLifecycleOwner, {
                if (index != null) {
                    val results = it.results
                    if (results != null) {
                        adapter.list = results.toMutableList()
                        rvResults.adapter = adapter
                    }
                }
            })
        }
    }
}