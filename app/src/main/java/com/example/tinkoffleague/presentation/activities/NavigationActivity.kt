package com.example.tinkoffleague.presentation.activities

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.get
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.tinkoffleague.R
import com.example.tinkoffleague.databinding.ActivityNavigationBinding
import com.example.tinkoffleague.presentation.AppViewModel
import com.google.android.material.navigation.NavigationView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_navigation.view.*
import kotlinx.android.synthetic.main.fragment_main_info.view.*
import kotlinx.android.synthetic.main.nav_header_nav.view.*

class NavigationActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityNavigationBinding
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var viewModel: AppViewModel
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]

        setSupportActionBar(binding.appBarNav.toolbar)
         drawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_nav)

        val index = intent?.getIntExtra("teamItem", -1)
        if (index != null) {
            viewModel.teamList.observe(this, {
                val team = it[index]
                Picasso.get().load(team.imageURL).into(navView.imageViewTeamClicked)
                navView.textViewTeamClicked.text = team.name
            })
        }

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home,
                R.id.nav_back,
                R.id.nav_info
            ), drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.nav, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_nav)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_back ->{
                startActivity(Intent(this@NavigationActivity,MainActivity::class.java))
                finish()
            }
            R.id.nav_info -> Toast.makeText(this,"INFO",Toast.LENGTH_SHORT).show()
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
