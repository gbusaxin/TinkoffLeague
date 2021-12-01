package com.example.tinkoffleague.data.mapper

import com.example.tinkoffleague.data.database.model.TeamInfoDbModel
import com.example.tinkoffleague.data.network.model.TeamInfoDto
import com.example.tinkoffleague.domain.pojo.TeamInfo

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

}