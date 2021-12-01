package com.example.tinkoffleague.presentation.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import com.example.tinkoffleague.R
import com.example.tinkoffleague.domain.pojo.TeamInfo
import com.example.tinkoffleague.presentation.ViewModelApp
import com.example.tinkoffleague.presentation.adapters.ChooseTeamAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ViewModelApp //AppViewModel
    lateinit var adapter: ChooseTeamAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[ViewModelApp::class.java]
        //viewModel.loadTeamsJson()

        viewModel.teamInfoList.observe(this, {
            adapter = ChooseTeamAdapter(it as ArrayList<TeamInfo>)
            adapter.teamList
            rvChooseTeam.adapter = adapter

            adapter.onTeamClickListener = {
                val intent = Intent(this@MainActivity, NavigationActivity::class.java)
                var index = it.name
                intent.putExtra("teamItem", index) ?: ""
                startActivity(intent)
            }
        })

        searchFavouriteTeam.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                adapter.filter.filter(p0)
                return false
            }
        })

    }

    override fun onDestroy() {
        super.onDestroy()
    }

}