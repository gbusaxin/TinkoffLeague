package com.example.tinkoffleague.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.tinkoffleague.data.ApiFactory
import com.example.tinkoffleague.data.database.AppDatabase
import com.example.tinkoffleague.domain.pojo.TeamItem
import com.example.tinkoffleague.domain.pojo.TournamentItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class AppViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)
    val teamList = db.teamDbDao().getTeamList()

    val liveDataMainInfo = MutableLiveData<List<TeamItem>>()
    val liveDataTournamentInfo = MutableLiveData<List<TournamentItem>>()
    private val compositeDisposable = CompositeDisposable()

    fun loadTournamentJson() {
        val disposable = ApiFactory.apiService.getTournamentFromJson()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                liveDataTournamentInfo.value = it
            }, {
                it.printStackTrace()
            })
        compositeDisposable.add(disposable)
    }

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

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}