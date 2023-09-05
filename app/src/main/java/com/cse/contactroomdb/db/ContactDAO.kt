package com.cse.contactroomdb.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.cse.contactroomdb.models.Contact

@Dao
interface ContactDAO {


    //CRUD
    @Insert
    suspend fun InsertContact(contact: Contact)

    @Update
    suspend fun UpdateContact(contact: Contact)

    @Delete
    suspend fun DeleteContact(contact: Contact)


    //Read
    @Query("SELECT * FROM Contact")
   suspend fun AllContact(): List<Contact>

}