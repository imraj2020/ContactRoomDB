package com.cse.contactroomdb.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cse.contactroomdb.models.Contact


@Database(entities = [Contact::class], version = 1)
abstract class ContactDatabase : RoomDatabase() {

    abstract fun getContactDao(): ContactDAO


    companion object {

        private var db: ContactDatabase? = null

        fun getInstance(context: Context): ContactDatabase {

            return if (db == null) {

                db = Room
                    .databaseBuilder(
                        context,
                        ContactDatabase::class.java,
                        "contact_db"
                    ).build()

                db as ContactDatabase

            } else {
                db as ContactDatabase

            }

        }
    }
}