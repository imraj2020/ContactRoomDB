package com.cse.contactroomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ContactDAO {


    //CRUD
    @Insert
    fun InsertContact(contact: Contact)

    @Update
    fun UpdateContact(contact: Contact)

    @Delete
    fun DeleteContact(contact: Contact)


    //Read
    @Query("SELECT * FROM Contact")
    fun AllContact(): List<Contact>

}