package com.cse.contactroomdb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.cse.contactroomdb.ContactRecycleView.ContactAdapter
import com.cse.contactroomdb.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate),ContactAdapter.Listener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val contactList: List<Contact> = db.getContactDao().AllContact()
        val adapter = ContactAdapter(contactList, this)

        binding.contactRCV.adapter = adapter


        binding.addbtn.setOnClickListener(View.OnClickListener {


            findNavController().navigate(R.id.action_homeFragment_to_detailsFragment)


        })





    }

    override fun contactclick(contact: Contact) {
        TODO("Not yet implemented")
    }


}