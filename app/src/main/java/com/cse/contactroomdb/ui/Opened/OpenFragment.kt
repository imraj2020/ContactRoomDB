package com.cse.contactroomdb.ui.Opened

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.cse.contactroomdb.R
import com.cse.contactroomdb.databinding.FragmentDetailsBinding
import com.cse.contactroomdb.databinding.FragmentOpenBinding
import com.cse.contactroomdb.models.Contact
import com.cse.contactroomdb.ui.ContactViewModel
import com.cse.contactroomdb.utils.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class OpenFragment : BaseFragment<FragmentOpenBinding>(FragmentOpenBinding::inflate) {

    val viewModel: ContactViewModel by viewModels()
    lateinit var contact: Contact


    companion object {
        const val contactKey = "contactKey"


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        contact = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requireArguments().getParcelable(contactKey, Contact::class.java)!!
        } else {
            requireArguments().getParcelable(contactKey)!!
        }
    }

  
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        contact.let {
            binding.nameTvs.setText(it.name)
            binding.emailTvs.setText(it.email)
            binding.mobileTvs.setText(it.phone)
        }





        binding.btnupdate.setOnClickListener(View.OnClickListener {

            contact.name = binding.nameTvs.text.toString()
            contact.email = binding.emailTvs.text.toString()
            contact.phone = binding.mobileTvs.text.toString()


            viewModel.viewModelScope.launch {
                viewModel.updateContact(contact)
            }


            findNavController().popBackStack()


        })
    }


}