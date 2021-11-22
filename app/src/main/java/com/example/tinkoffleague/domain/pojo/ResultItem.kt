package com.example.tinkoffleague.domain.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Entity(tableName = "results_list")
data class ResultItem (

    @PrimaryKey(autoGenerate = true)
    val id:Int,

    @SerializedName("enemy")
    @Expose
    val enemy: String? = null,

    @SerializedName("type")
    @Expose
    val type: String? = null,

    @SerializedName("result")
    @Expose
    val result: String? = null,

    @SerializedName("date")
    @Expose
    val date: String? = null,

    @SerializedName("status")
    @Expose
    val status: Int = 0,

    @SerializedName("imageURL")
    @Expose
    val imageURL: String? = null
)