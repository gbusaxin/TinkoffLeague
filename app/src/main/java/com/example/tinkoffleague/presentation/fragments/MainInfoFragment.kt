package com.example.tinkoffleague.presentation.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.tinkoffleague.R
import com.example.tinkoffleague.domain.pojo.TeamItem
import com.example.tinkoffleague.presentation.AppViewModel
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_main_info.*

class MainInfoFragment : Fragment() {

    private lateinit var viewModel:AppViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]

        val index = activity?.intent?.getIntExtra("teamItem",-1)
        viewModel.teamList.observe(viewLifecycleOwner,{
            if (index!=null) {
                val team = it[index]
                with(team) {
                    Picasso.get().load(imageURL).into(imageMainInfo)
                    nameBannerInfo.text = name
                    fullnameBannerInfo.text = fullname
                    nicknamesBannerInfo.text = nicknames
                    foundedBannerInfo.text = founded
                    websiteBannerInfo.text = website
                    venueNameBannerInfo.text = venueName
                    venueCapacityBannerInfo.text = venueCapacity.toString()
                    staffGenDirBannerInfo.text = gendir
                    mainTrainerBannerInfo.text = trainer
                    staffCapitanBannerInfo.text = captain
                    Log.d("FRAGMENT_CHECK", team.toString())
                }
            }
        })
    }
}