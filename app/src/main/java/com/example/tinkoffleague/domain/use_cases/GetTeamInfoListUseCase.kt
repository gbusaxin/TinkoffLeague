package com.example.tinkoffleague.domain.use_cases

import com.example.tinkoffleague.domain.TeamRepository

class GetTeamInfoListUseCase(private val repository: TeamRepository) {
    operator fun invoke() = repository.getTeamInfoList()
}