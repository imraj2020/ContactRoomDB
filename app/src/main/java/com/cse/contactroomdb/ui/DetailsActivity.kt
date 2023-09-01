package com.cse.contactroomdb.ui

import android.os.Build
import android.os.Build.VERSION_CODES
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.cse.contactroomdb.models.Contact
import com.cse.contactroomdb.databinding.ActivityDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
//    companion object {
//        const val contactKey = "contactKey"
//
//
//    }
//
//    private lateinit var binding: ActivityDetailsBinding
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityDetailsBinding.inflate(layoutInflater)
//
//        setContentView(binding.root)
//
//        val contact = if (Build.VERSION.SDK_INT >= VERSION_CODES.TIRAMISU) {
//            intent.getParcelableExtra(contactKey, Contact::class.java)
//        } else {
//            intent.getParcelableExtra(contactKey)
//        }
//
//        contact?.let {
//
//            binding.apply {
//                nameTv.text = it.name
//                emailTv.text = it.email
//                mobileTv.text = it.phone
//
//
//            }
//
//
//        }
//
//
//    }
}