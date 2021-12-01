package com.example.tinkoffleague.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tinkoffleague.R
import com.example.tinkoffleague.presentation.adapters.AppViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_view_pager_item.*


class ViewPagerItemFragment : Fragment() {

    lateinit var viewPagerAdapter: AppViewPagerAdapter
    lateinit var mainInfoFragment: MainInfoFragment
    lateinit var fixturesFragment: FixturesFragment
    lateinit var resultsFragment: ResultsFragment
    lateinit var playerFragment: PlayerFragment
    lateinit var tournamentFragment: TournamentFragment

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_view_pager_item, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainInfoFragment = MainInfoFragment()
        fixturesFragment = FixturesFragment()
        resultsFragment = ResultsFragment()
        playerFragment = PlayerFragment()
        tournamentFragment = TournamentFragment()

        val support = activity?.supportFragmentManager
        if (support != null)
        viewPagerAdapter = AppViewPagerAdapter(support)
        viewPagerAdapter.addFragment(mainInfoFragment, "основное")
        viewPagerAdapter.addFragment(fixturesFragment, "матчи")
        viewPagerAdapter.addFragment(resultsFragment, "результаты")
        viewPagerAdapter.addFragment(playerFragment, "состав")
        viewPagerAdapter.addFragment(tournamentFragment, "турнир")
        viewPager.adapter = viewPagerAdapter
        tabs.setupWithViewPager(viewPager)
    }
}