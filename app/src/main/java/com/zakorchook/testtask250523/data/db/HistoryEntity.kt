package com.zakorchook.testtask250523.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class HistoryEntity(
    val datetime: Long
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}