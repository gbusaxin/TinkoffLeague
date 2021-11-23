package com.example.tinkoffleague.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tinkoffleague.domain.pojo.FixturesItem
import com.example.tinkoffleague.domain.pojo.PlayerItem
import com.example.tinkoffleague.domain.pojo.ResultItem
import com.example.tinkoffleague.domain.pojo.TeamItem

@Dao
interface TeamDbDao {

    @Query("SELECT * FROM teams_list")
    fun getTeamList():LiveData<List<TeamItem>>

    @Query("SELECT * FROM teams_list WHERE name == :teamName")
    fun getTeamInfo(teamName: String):LiveData<TeamItem>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTeamList(teamList:List<TeamItem>)


}