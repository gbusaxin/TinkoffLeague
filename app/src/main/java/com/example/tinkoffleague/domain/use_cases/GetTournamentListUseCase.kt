package com.example.tinkoffleague.domain.use_cases

import com.example.tinkoffleague.domain.TeamRepository

class GetTournamentListUseCase(private val repository: TeamRepository) {
    operator fun invoke() = repository.getTournamentList()
}