package com.cse.contactroomdb.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cse.contactroomdb.models.Contact
import com.cse.contactroomdb.repos.ContactRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(var repo: ContactRepo) : ViewModel() {

    fun getAllContact():LiveData<List<Contact>> {

        return repo.getAllContact()
    }
}