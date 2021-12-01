package com.example.tinkoffleague.domain.use_cases

import com.example.tinkoffleague.domain.TeamRepository

class LoadTournamentsUseCase(private val repository: TeamRepository) {
    suspend operator fun invoke() = repository.loadTournament()
}