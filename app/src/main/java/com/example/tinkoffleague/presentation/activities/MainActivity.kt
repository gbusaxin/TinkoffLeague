package com.example.tinkoffleague.presentation.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import com.example.tinkoffleague.R
import com.example.tinkoffleague.domain.pojo.TeamItem
import com.example.tinkoffleague.presentation.AppViewModel
import com.example.tinkoffleague.presentation.adapters.ChooseTeamAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: AppViewModel
    lateinit var adapter: ChooseTeamAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[AppViewModel::class.java]
        viewModel.loadTeamsJson()
        viewModel.teamList.observe(this,{
            adapter = ChooseTeamAdapter(it as ArrayList<TeamItem>)
            rvChooseTeam.adapter = adapter

        })

        searchFavouriteTeam.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(p0: String?): Boolean {
                adapter.filter.filter(p0)
                return false
            }
        })

        adapter.onTeamClickListener = {
            val intent = Intent(this@MainActivity,MenuActivity::class.java)
            val index = viewModel.teamList.value?.indexOf(it)
            intent.putExtra("teamItem",index)
            startActivity(intent)
            finish()
        }

    }



}