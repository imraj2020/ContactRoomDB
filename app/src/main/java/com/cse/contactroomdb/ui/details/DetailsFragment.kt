package com.cse.contactroomdb.ui.details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.cse.contactroomdb.utils.BaseFragment
import com.cse.contactroomdb.models.Contact
import com.cse.contactroomdb.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel: DetailsViewModel by viewModels()

        binding.btnsave.setOnClickListener(View.OnClickListener {

            val contacts = Contact(
                0,
                binding.etname.text.toString(),
                binding.etemail.text.toString(),
                binding.etphone.text.toString()
            )


            viewModel.insertContact(contacts)


            findNavController().popBackStack()


        })


    }


}