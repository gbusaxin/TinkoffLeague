package com.example.tinkoffleague.domain.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Entity(tableName = "fixtures_list")
data class FixturesItem (

    @PrimaryKey(autoGenerate = true)
    val id:Int,

    @SerializedName("enemy")
    @Expose
    val enemy: String? = null,

    @SerializedName("type")
    @Expose
    val type: String? = null,

    @SerializedName("date")
    @Expose
    val date: String? = null,

    @SerializedName("imageURL")
    @Expose
    val imageURL: String? = null
)