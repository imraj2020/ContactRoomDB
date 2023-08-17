package com.cse.contactroomdb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cse.contactroomdb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var db = Room.databaseBuilder(applicationContext, ContactDatabase::class.java, "Contact.db")
            .allowMainThreadQueries().build()

        binding.button1.setOnClickListener(View.OnClickListener {

            val Contacts = Contact(
                0,
                binding.editText1.text.toString(),
                binding.editText2.text.toString(),
                binding.editText3.text.toString()
            )

            db.getContactDao().InsertContact(Contacts)


        })

        binding.button2.setOnClickListener(View.OnClickListener {

            binding.mylinear.visibility = View.GONE
            binding.mylinear2.visibility= View.VISIBLE

            val contactList: List<Contact> = db.getContactDao().AllContact()
            var contactlist = ""

            contactList.forEach {
                contactlist += "${it.name + " "},${it.email + " "},${it.phone + " "}\n\n"
            }

            binding.contactlists.text = contactlist

        })

        binding.backbtn.setOnClickListener(View.OnClickListener {
            binding.mylinear.visibility = View.VISIBLE
            binding.mylinear2.visibility= View.GONE
        })




    }
}