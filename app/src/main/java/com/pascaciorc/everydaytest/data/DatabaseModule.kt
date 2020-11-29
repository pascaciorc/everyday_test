package com.pascaciorc.everydaytest.data

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@InstallIn(ApplicationComponent::class)
@Module
class DatabaseModule {
    @Provides
    fun provideTakeDao(database: Database) = database.takeDao()

    @Provides
    fun provideDatabase(@ApplicationContext applicationContext: Context) =
        Room.databaseBuilder(
            applicationContext,
            Database::class.java,
            "database"
        ).build()

}