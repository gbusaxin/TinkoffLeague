package com.example.tinkoffleague.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tinkoffleague.data.ApiFactory
import com.example.tinkoffleague.data.database.AppDatabase
import com.example.tinkoffleague.domain.pojo.FixturesItem
import com.example.tinkoffleague.domain.pojo.PlayerItem
import com.example.tinkoffleague.domain.pojo.ResultItem
import com.example.tinkoffleague.domain.pojo.TeamItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AppViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)
    val teamList = db.teamDbDao().getTeamList()

    val liveDataMainInfo = MutableLiveData<List<TeamItem>>()
    val liveDataPlayerInfo = MutableLiveData<List<PlayerItem>>()
    val liveDataResultInfo = MutableLiveData<List<ResultItem>>()
    val liveDataFixturesInfo = MutableLiveData<List<FixturesItem>>()

    private val compositeDisposable = CompositeDisposable()

    fun loadTeamsJson() {
        val disposable = ApiFactory.apiService.getTeamFromJson()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                db.teamDbDao().insertTeamList(it)
                liveDataMainInfo.value = it
            }, {
                it.printStackTrace()
            })
        compositeDisposable.add(disposable)
    }

    fun loadPlayersJson() {
        val disposable = ApiFactory.apiService.getPlayersFromJson()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                       db.teamDbDao().insertPlayersList(it)
                liveDataPlayerInfo.value = it
            }, {
                it.printStackTrace()
            })
        compositeDisposable.add(disposable)
    }

    fun loadResultJson(){
        val disposable = ApiFactory.apiService.getResultsFromJson()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                db.teamDbDao().insertResultList(it)
                liveDataResultInfo.value = it
            },{
                it.printStackTrace()
            })
        compositeDisposable.add(disposable)
    }

    fun loadFixturesJson(){
        val disposable = ApiFactory.apiService.getFixturesFromJson()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                db.teamDbDao().insertFixturesList(it)
                liveDataFixturesInfo.value = it
            },{
                it.printStackTrace()
            })
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}