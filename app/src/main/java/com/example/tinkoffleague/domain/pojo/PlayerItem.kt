package com.example.tinkoffleague.domain.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Entity(tableName = "players_list")
data class PlayerItem (

    @PrimaryKey(autoGenerate = true)
    val id:Int,

    @SerializedName("imagePlayer")
    @Expose
    val imagePlayer: String? = null,

    @SerializedName("name")
    @Expose
    val name: String? = null,

    @SerializedName("position")
    @Expose
    val position: String? = null
)