package com.example.tinkoffleague.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tinkoffleague.R
import com.example.tinkoffleague.presentation.ViewModelApp
import com.example.tinkoffleague.presentation.adapters.FixturesAdapter
import kotlinx.android.synthetic.main.fragment_fixtures.*

class FixturesFragment : Fragment() {

    private lateinit var viewModel: ViewModelApp
    private lateinit var adapter: FixturesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[ViewModelApp::class.java]
        adapter = FixturesAdapter()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fixtures, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val index = activity?.intent?.getStringExtra("teamItem")

        if (index != null) {
            viewModel.getTeamInfo(index).observe(viewLifecycleOwner, {
                if (index != null){
                    val fixtures = it.fixtures
                            if (fixtures != null) {
                                adapter.list = fixtures.toMutableList()
                                rvFixtures.adapter = adapter
                            }
                }
            })
        }
    }
}