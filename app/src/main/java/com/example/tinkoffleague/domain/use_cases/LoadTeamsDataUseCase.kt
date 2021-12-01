package com.example.tinkoffleague.domain.use_cases

import com.example.tinkoffleague.domain.TeamRepository

class LoadTeamsDataUseCase(private val repository: TeamRepository) {
    suspend operator fun invoke() = repository.loadData()
}