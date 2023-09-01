package com.cse.contactroomdb.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cse.contactroomdb.models.Contact
import com.cse.contactroomdb.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ContactAdapter.Listener {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)









    }

    override fun contactclick(contact: Contact) {

//
//        val intent = Intent(this@MainActivity, DetailsActivity::class.java)
//        intent.putExtra(DetailsActivity.contactKey, contact)
//        startActivity(intent)

    }
}

