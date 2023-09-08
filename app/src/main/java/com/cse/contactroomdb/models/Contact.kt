package com.cse.contactroomdb.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Parcelize
@Entity
data class Contact(

    @PrimaryKey(autoGenerate = true)
    val id:Int,
    var name: String,
    var email: String,
    var phone: String

) : Parcelable