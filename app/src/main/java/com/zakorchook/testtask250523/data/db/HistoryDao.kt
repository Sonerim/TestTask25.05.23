package com.zakorchook.testtask250523.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HistoryDao {
    @Query("SELECT * FROM historyEntity")
    suspend fun getAll(): List<HistoryEntity>

    @Insert
    suspend fun insertItem(historyEntity: HistoryEntity)
}