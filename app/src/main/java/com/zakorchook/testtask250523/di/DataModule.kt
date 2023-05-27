package com.zakorchook.testtask250523.di

import android.content.Context
import androidx.room.Room
import com.zakorchook.testtask250523.data.db.AppDatabase
import com.zakorchook.testtask250523.data.db.HistoryDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideHistoryDao(@ApplicationContext appContext: Context): HistoryDao {
        return Room.databaseBuilder(
            appContext, AppDatabase::class.java, "my-db"
        ).build().historyDao()
    }
}