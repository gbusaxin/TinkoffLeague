package com.example.tinkoffleague.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.tinkoffleague.R
import com.example.tinkoffleague.presentation.AppViewModel
import com.example.tinkoffleague.presentation.adapters.AppViewPagerAdapter
import com.example.tinkoffleague.presentation.fragments.FixturesFragment
import com.example.tinkoffleague.presentation.fragments.MainInfoFragment
import com.example.tinkoffleague.presentation.fragments.PlayerFragment
import com.example.tinkoffleague.presentation.fragments.ResultsFragment
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    lateinit var viewPagerAdapter:AppViewPagerAdapter
    lateinit var mainInfoFragment: MainInfoFragment
    lateinit var fixturesFragment: FixturesFragment
    lateinit var resultsFragment: ResultsFragment
    lateinit var playerFragment: PlayerFragment
    lateinit var viewModel: AppViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        viewModel = ViewModelProvider(this)[AppViewModel::class.java]
        mainInfoFragment = MainInfoFragment()
        fixturesFragment = FixturesFragment()
        resultsFragment = ResultsFragment()
        playerFragment = PlayerFragment()

        viewPagerAdapter = AppViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(mainInfoFragment,"основное")
        viewPagerAdapter.addFragment(fixturesFragment,"матчи")
        viewPagerAdapter.addFragment(resultsFragment,"результаты")
        viewPagerAdapter.addFragment(playerFragment,"состав")
        viewPager.adapter = viewPagerAdapter
        tabs.setupWithViewPager(viewPager)
    }



}