package com.example.tinkoffleague.data.database.converters

import androidx.room.TypeConverter
import com.example.tinkoffleague.domain.pojo.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.*


class DatabaseConverters {

    @TypeConverter
    fun toVenueFromJson(venue:String):VenueItem{
        if (venue == null) return VenueItem("",0)
        val type: Type = object : TypeToken<VenueItem?>() {}.type
        return Gson().fromJson(venue, type)
    }

    @TypeConverter
    fun fromJsonToVenue(venue:VenueItem):String{
        return Gson().toJson(venue)
    }

    @TypeConverter
    fun toStaffFromJson(staff:String):StaffItem{
        if (staff == null) return StaffItem("","","")
        val type: Type = object : TypeToken<StaffItem?>() {}.type
        return Gson().fromJson(staff, type)
    }

    @TypeConverter
    fun fromJsonToStaff(staff:StaffItem):String{
        return Gson().toJson(staff)
    }

    @TypeConverter
    fun toListPlayersFromJson(players:String):List<PlayerItem>{
        if (players == null) return Collections.emptyList()
        val type: Type = object : TypeToken<List<PlayerItem?>?>() {}.type
        return Gson().fromJson(players, type)
    }

    @TypeConverter
    fun fromJsonToListPlayers(playerList:List<PlayerItem>):String{
        return Gson().toJson(playerList)
    }

    @TypeConverter
    fun toListResultsFromJson(results:String):List<ResultItem>{
        if (results == null) return Collections.emptyList()
        val type: Type = object : TypeToken<List<ResultItem?>?>() {}.type
        return Gson().fromJson(results, type)
    }

    @TypeConverter
    fun fromJsonToListResults(resultsList:List<ResultItem>):String{
        return Gson().toJson(resultsList)
    }

    @TypeConverter
    fun toListFixturesFromJson(fixtures:String):List<FixturesItem>{
        if (fixtures == null) return Collections.emptyList()
        val type: Type = object : TypeToken<List<FixturesItem?>?>() {}.type
        return Gson().fromJson(fixtures, type)
    }

    @TypeConverter
    fun fromJsonToListFixtures(fixturesList:List<FixturesItem>):String{
        return Gson().toJson(fixturesList)
    }
}