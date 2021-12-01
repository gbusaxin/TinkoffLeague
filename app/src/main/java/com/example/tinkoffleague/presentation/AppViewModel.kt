package com.example.tinkoffleague.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.tinkoffleague.data.network.ApiFactory
import com.example.tinkoffleague.data.database.AppDatabase
import com.example.tinkoffleague.data.database.model.TeamInfoDbModel
import com.example.tinkoffleague.data.network.model.TournamentInfoDto
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch

class AppViewModel(application: Application) : AndroidViewModel(application) {

    private val db = AppDatabase.getInstance(application)
    val teamList = db.teamDbDao().getTeamList()

    val liveDataMainInfo = MutableLiveData<List<TeamInfoDbModel>>()
    val liveDataTournamentInfo = MutableLiveData<List<TournamentInfoDto>>()

    private val compositeDisposable = CompositeDisposable()

     fun loadTournamentJson() {
//        viewModelScope.launch {
//            val disposable = ApiFactory.apiService.getTournamentFromJson()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({
//                    liveDataTournamentInfo.value = it
//                }, {
//                    it.printStackTrace()
//                })
//            compositeDisposable.add(disposable)
//        }
    }

     fun loadTeamsJson() {
//        val disposable = ApiFactory.apiService.getTeamFromJson()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                viewModelScope.launch {
//                    db.teamDbDao().insertTeamList(it)
//                    liveDataMainInfo.value = it
//                }
//            }, {
//                it.printStackTrace()
//            })
//        compositeDisposable.add(disposable)
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}