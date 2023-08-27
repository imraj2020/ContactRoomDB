package com.cse.contactroomdb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cse.contactroomdb.ContactRecycleView.ContactAdapter
import com.cse.contactroomdb.DetailsActivity.contactkey.contactKey
import com.cse.contactroomdb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ContactAdapter.Listener {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)









    }

    override fun contactclick(contact: Contact) {


        val intent = Intent(this@MainActivity, DetailsActivity::class.java)
        intent.putExtra(DetailsActivity.contactKey, contact)
        startActivity(intent)

    }
}

