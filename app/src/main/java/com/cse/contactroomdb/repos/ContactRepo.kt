package com.cse.contactroomdb.repos

import androidx.lifecycle.LiveData
import com.cse.contactroomdb.db.ContactDAO
import com.cse.contactroomdb.models.Contact
import javax.inject.Inject

class ContactRepo @Inject constructor(private  val  dao: ContactDAO) {



   suspend fun getAllContact():List<Contact> {

        return dao.AllContact()
    }

   suspend fun insertContact(contact: Contact) {
        dao.InsertContact(contact)
    }

}