package com.cse.contactroomdb.ui.home

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cse.contactroomdb.utils.BaseFragment
import com.cse.contactroomdb.models.Contact
import com.cse.contactroomdb.R
import com.cse.contactroomdb.databinding.FragmentHomeBinding
import com.cse.contactroomdb.ui.ContactAdapter
import com.cse.contactroomdb.ui.ContactViewModel
import com.cse.contactroomdb.ui.Opened.OpenFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate),
    ContactAdapter.Listener {
    val viewModel: ContactViewModel by viewModels()
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

        val bundle = Bundle()
        bundle.putParcelable(OpenFragment.contactKey,contact)
        findNavController().navigate(R.id.action_homeFragment_to_openFragment,bundle)
    }

    override fun deleteclick(contact: Contact) {
        var alertdialog = AlertDialog.Builder(requireContext())
            .setTitle("Are you Sure ?")
            .setMessage("This will delete that item.")
            .setPositiveButton("OK", object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {

                    viewModel.deleteContact(contact)
                    Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show()
                }
            })
            .setNegativeButton("NO", object : DialogInterface.OnClickListener {
                override fun onClick(p0: DialogInterface?, p1: Int) {
                    Toast.makeText(context, "No Clicked", Toast.LENGTH_SHORT).show()
                }
            })
        val dialog = alertdialog.create()
        dialog.show()

    }


}