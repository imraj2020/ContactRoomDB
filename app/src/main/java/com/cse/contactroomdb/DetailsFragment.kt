package com.cse.contactroomdb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.room.Room
import com.cse.contactroomdb.ContactRecycleView.ContactAdapter
import com.cse.contactroomdb.databinding.FragmentDetailsBinding
import com.cse.contactroomdb.databinding.FragmentHomeBinding

class DetailsFragment : BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnsave.setOnClickListener(View.OnClickListener {

            val Contacts = Contact(
                0,
                binding.etname.text.toString(),
                binding.etemail.text.toString(),
                binding.etphone.text.toString()
            )

            db.getContactDao().InsertContact(Contacts)

            findNavController().navigate(R.id.action_detailsFragment_to_homeFragment)


        })


    }


}