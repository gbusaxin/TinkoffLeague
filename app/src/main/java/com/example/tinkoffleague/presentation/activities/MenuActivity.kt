package com.example.tinkoffleague.presentation.activities

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tinkoffleague.R
import com.example.tinkoffleague.domain.rv_item.NavigationItemModel
import com.example.tinkoffleague.presentation.AppViewModel
import com.example.tinkoffleague.presentation.adapters.AppViewPagerAdapter
import com.example.tinkoffleague.presentation.adapters.NavigationRVAdapter
import com.example.tinkoffleague.presentation.adapters.listeners.ClickListener
import com.example.tinkoffleague.presentation.adapters.listeners.RecyclerTouchListener
import com.example.tinkoffleague.presentation.fragments.*
import kotlinx.android.synthetic.main.activity_menu.*

class MenuActivity : AppCompatActivity() {

    lateinit var viewPagerAdapter:AppViewPagerAdapter
    lateinit var mainInfoFragment: MainInfoFragment
    lateinit var fixturesFragment: FixturesFragment
    lateinit var resultsFragment: ResultsFragment
    lateinit var playerFragment: PlayerFragment
    lateinit var tournamentFragment: TournamentFragment

    lateinit var viewModel: AppViewModel

    private lateinit var adapter: NavigationRVAdapter

    private var items = arrayListOf(
        NavigationItemModel(R.drawable.ic_baseline_arrow_back_24, "Выбрать другую команду"),
        NavigationItemModel(R.drawable.ic_os_notification_fallback_white_24dp, "Информация")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        setSupportActionBar(activity_main_toolbar)

        navigation_rv.layoutManager = LinearLayoutManager(this)
        navigation_rv.setHasFixedSize(true)

        navigation_rv.addOnItemTouchListener(RecyclerTouchListener(this, object : ClickListener {
            override fun onClick(view: View, position: Int) {
                when (position) {
                    0 -> {
                        // # выбрать другую команду
                        startActivity(Intent(this@MenuActivity,MainActivity::class.java))
                        finish()
                    }
                    1 -> {
                        // # информация

                    }
                }
                if (position != 6 && position != 4) {
                    updateAdapter(position)
                }
                Handler().postDelayed({
                    drawer_layout.closeDrawer(GravityCompat.START)
                }, 200)
            }
        }))

        //navigation_header_img.setImageResource(R.drawable.logo)

        viewModel = ViewModelProvider(this)[AppViewModel::class.java]
        mainInfoFragment = MainInfoFragment()
        fixturesFragment = FixturesFragment()
        resultsFragment = ResultsFragment()
        playerFragment = PlayerFragment()
        tournamentFragment = TournamentFragment()

        viewPagerAdapter = AppViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.addFragment(mainInfoFragment,"основное")
        viewPagerAdapter.addFragment(fixturesFragment,"матчи")
        viewPagerAdapter.addFragment(resultsFragment,"результаты")
        viewPagerAdapter.addFragment(playerFragment,"состав")
        viewPagerAdapter.addFragment(tournamentFragment,"турнир")
        viewPager.adapter = viewPagerAdapter
        tabs.setupWithViewPager(viewPager)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            if (supportFragmentManager.backStackEntryCount > 0) {
                supportFragmentManager.popBackStack()
            } else {
                super.onBackPressed()
            }
        }
    }

    private fun updateAdapter(highlightItemPos: Int) {
        adapter = NavigationRVAdapter(items, highlightItemPos)
        navigation_rv.adapter = adapter
        adapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

}