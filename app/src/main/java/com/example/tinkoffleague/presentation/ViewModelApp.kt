package com.example.tinkoffleague.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.tinkoffleague.data.repository.TeamRepositoryImpl
import com.example.tinkoffleague.domain.use_cases.GetTeamInfoListUseCase
import com.example.tinkoffleague.domain.use_cases.GetTeamInfoUseCase
import com.example.tinkoffleague.domain.use_cases.LoadTeamsDataUseCase
import kotlinx.coroutines.launch

class ViewModelApp(application: Application):AndroidViewModel(application) {

    private val repository = TeamRepositoryImpl(application)
    private val getTeamInfoListUseCase = GetTeamInfoListUseCase(repository)
    private val getTeamInfoUseCase = GetTeamInfoUseCase(repository)
    private val loadTeamsDataUseCase = LoadTeamsDataUseCase(repository)

    val teamInfoList = getTeamInfoListUseCase()

    fun getTeamInfo(teamName:String) = getTeamInfoUseCase(teamName)

    init {
        viewModelScope.launch {
            loadTeamsDataUseCase()
        }
    }
}