package com.example.tinkoffleague.data.mapper

import com.example.tinkoffleague.data.database.model.TeamInfoDbModel
import com.example.tinkoffleague.data.database.model.TournamentInfoDbModel
import com.example.tinkoffleague.data.network.model.TeamInfoDto
import com.example.tinkoffleague.data.network.model.TournamentInfoDto
import com.example.tinkoffleague.domain.pojo.TeamInfo
import com.example.tinkoffleague.domain.pojo.TournamentInfo

class TeamMapper {

    fun mapDtoToDbModel(dto: TeamInfoDto) = TeamInfoDbModel(
        name = dto.name,
        fullname = dto.fullname,
        nicknames = dto.nicknames,
        founded = dto.founded,
        website = dto.website,
        imageURL = dto.imageURL,
        smallImageURL = dto.smallImageURL,
        venueName = dto.venueName,
        venueCapacity = dto.venueCapacity,
        gendir = dto.gendir,
        trainer = dto.trainer,
        captain = dto.captain,
        players = dto.players,
        results = dto.results,
        fixtures = dto.fixtures
    )

    fun mapDbModelToEntity(dbModel: TeamInfoDbModel) = TeamInfo(
        name = dbModel.name,
        fullname = dbModel.fullname,
        nicknames = dbModel.nicknames,
        founded = dbModel.founded,
        website = dbModel.website,
        imageURL = dbModel.imageURL,
        smallImageURL = dbModel.smallImageURL,
        venueName = dbModel.venueName,
        venueCapacity = dbModel.venueCapacity,
        gendir = dbModel.gendir,
        trainer = dbModel.trainer,
        captain = dbModel.captain,
        players = dbModel.players,
        results = dbModel.results,
        fixtures = dbModel.fixtures
    )

    fun mapTournamentDbModelToEntity(dbModel:TournamentInfoDbModel) = TournamentInfo(
        teamPosition = dbModel.teamPosition,
        teamImage = dbModel.teamImage,
        teamName = dbModel.teamName,
        n = dbModel.n,
        b = dbModel.b,
        h = dbModel.h,
        p = dbModel.p,
        zP = dbModel.zP,
        scores = dbModel.scores
    )

    fun mapTournamentDtoToDbModel(dto:TournamentInfoDto) = TournamentInfoDbModel(
        teamPosition = dto.teamPosition,
        teamImage = dto.teamImage,
        teamName = dto.teamName,
        n = dto.n,
        b = dto.b,
        h = dto.h,
        p = dto.p,
        zP = dto.zP,
        scores = dto.scores
    )

}