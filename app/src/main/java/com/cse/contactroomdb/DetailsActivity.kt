package com.cse.contactroomdb

import android.os.Build
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.cse.contactroomdb.databinding.ActivityDetailsBinding
import com.cse.contactroomdb.databinding.ActivityMainBinding

class DetailsActivity : AppCompatActivity() {
    companion object contactkey {

        const val contactKey = "contactKey"
    }

    lateinit var binding: ActivityDetailsBinding

    @RequiresApi(VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val contact = if (Build.VERSION.SDK_INT >= VERSION_CODES.TIRAMISU) {

            intent.getParcelableExtra(contactKey, Contact::class.java)

        } else {

            intent.getParcelableExtra(contactKey)
        }

        contact?.let {
            binding.apply {
                nameTv.text = it.name
                emailTv.text=it.email
                mobileTv.text = it.phone
            }
        }

    }
}