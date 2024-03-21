package com.example.composenihal.todo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todoTable")
data class Todo(
    @PrimaryKey
    val title: String,
    val description: String
) /*{
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
}*/
