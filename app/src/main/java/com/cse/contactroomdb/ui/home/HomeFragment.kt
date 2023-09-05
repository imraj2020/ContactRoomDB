package com.cse.contactroomdb.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cse.contactroomdb.utils.BaseFragment
import com.cse.contactroomdb.models.Contact
import com.cse.contactroomdb.R
import com.cse.contactroomdb.databinding.FragmentHomeBinding
import com.cse.contactroomdb.ui.ContactAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate),
    ContactAdapter.Listener {
    val viewModel: HomeViewModel by viewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.getAllContact()

        viewModel.allcontact.observe(viewLifecycleOwner) {

            val adapter = ContactAdapter(it, this)
            binding.contactRCV.adapter = adapter
        }




        binding.addbtn.setOnClickListener(View.OnClickListener {


            findNavController().navigate(R.id.action_homeFragment_to_detailsFragment)


        })


    }


    override fun contactclick(contact: Contact) {
        TODO("Not yet implemented")
    }


}