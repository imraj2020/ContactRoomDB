package com.cse.contactroomdb.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cse.contactroomdb.models.Contact
import com.cse.contactroomdb.repos.ContactRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(var repo: ContactRepo) : ViewModel() {

   private var _allcontact : MutableLiveData<List<Contact>> = MutableLiveData<List<Contact>>()

    val  allcontact:LiveData<List<Contact>> get()  = _allcontact

   fun getAllContact() {

        viewModelScope.launch{

            _allcontact.postValue(repo.getAllContact())
        }
    }


    fun deleteContact(contact: Contact){
        viewModelScope.launch {
            repo.deleteContact(contact)
            getAllContact()
        }
    }


    fun updateContact(contact: Contact){
        viewModelScope.launch {
            repo.updateContact(contact)
            getAllContact()
        }

    }

}