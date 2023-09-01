package com.cse.contactroomdb.ui.details

import android.provider.ContactsContract.Intents.Insert
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cse.contactroomdb.models.Contact
import com.cse.contactroomdb.repos.ContactRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val repo: ContactRepo) : ViewModel() {


 suspend  fun insertContact(contact: Contact) {
        viewModelScope.launch {
            repo.insertContact(contact)
        }
    }
}