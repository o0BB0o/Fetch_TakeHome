package com.example.yifan_fetch_th.database
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Hiring")
data class Candidates (
    @PrimaryKey(autoGenerate = false)
    var id: Int,

    @ColumnInfo(name = "listId")
    var listId: Int,

    @ColumnInfo(name = "name")
    var name: String
)