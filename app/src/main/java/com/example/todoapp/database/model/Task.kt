package com.example.todoapp.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String? = null,
    val description: String? = null,
    @ColumnInfo(index = true)
    val date: Long? = null,
    val time: Long? = null,
    val status: Boolean = false
)