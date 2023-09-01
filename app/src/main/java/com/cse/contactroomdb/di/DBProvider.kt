package com.cse.contactroomdb.di

import android.content.Context
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.room.Room
import com.cse.contactroomdb.db.ContactDAO
import com.cse.contactroomdb.db.ContactDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)

class DBProvider {
    @Provides
    @Singleton
    fun dbprovider(@ApplicationContext context: Context):ContactDatabase{

        return  ContactDatabase.getInstance(context)

    }

    @Provides
    @Singleton
    fun daoprovider(db:ContactDatabase): ContactDAO {

        return db.getContactDao()
    }





}