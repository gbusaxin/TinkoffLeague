package com.example.tinkoffleague.domain.use_cases

import com.example.tinkoffleague.domain.TeamRepository

class GetTeamInfoUseCase(private var repository: TeamRepository) {
    operator fun invoke(teamName:String) = repository.getTeamInfo(teamName)
}