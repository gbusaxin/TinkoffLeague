package com.example.tinkoffleague.data.database.converters

import androidx.room.TypeConverter
import com.example.tinkoffleague.domain.pojo.FixturesInfo
import com.example.tinkoffleague.domain.pojo.PlayerInfo
import com.example.tinkoffleague.domain.pojo.ResultInfo
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*


class DatabaseConverters {

    @TypeConverter
    fun toListPlayersFromJson(players:String):List<PlayerInfo>{
        if (players == null) return Collections.emptyList()
        val type: Type = object : TypeToken<List<PlayerInfo?>?>() {}.type
        return Gson().fromJson(players, type)
    }

    @TypeConverter
    fun fromJsonToListPlayers(playerList:List<PlayerInfo>):String{
        return Gson().toJson(playerList)
    }

    @TypeConverter
    fun toListResultsFromJson(results:String):List<ResultInfo>{
        if (results == null) return Collections.emptyList()
        val type: Type = object : TypeToken<List<ResultInfo?>?>() {}.type
        return Gson().fromJson(results, type)
    }

    @TypeConverter
    fun fromJsonToListResults(resultsList:List<ResultInfo>):String{
        return Gson().toJson(resultsList)
    }

    @TypeConverter
    fun toListFixturesFromJson(fixtures:String):List<FixturesInfo>{
        if (fixtures == null) return Collections.emptyList()
        val type: Type = object : TypeToken<List<FixturesInfo?>?>() {}.type
        return Gson().fromJson(fixtures, type)
    }

    @TypeConverter
    fun fromJsonToListFixtures(fixturesList:List<FixturesInfo>):String{
        return Gson().toJson(fixturesList)
    }
}