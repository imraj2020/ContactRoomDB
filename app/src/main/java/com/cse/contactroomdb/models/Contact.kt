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
    val name: String,
    val email: String,
    val phone: String

) : Parcelable