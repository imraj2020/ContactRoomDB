package com.cse.contactroomdb

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.room.Room
import androidx.viewbinding.ViewBinding


abstract class BaseFragment<VB : ViewBinding>(
    private var bindingInflater: (inflater: LayoutInflater) -> VB
) : Fragment() {
    lateinit var db:ContactDatabase
    private var _binding: VB? = null
    val binding: VB get()  = _binding as VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        db = Room.databaseBuilder(requireContext(), ContactDatabase::class.java, "Contact.db")
            .allowMainThreadQueries().build()
        _binding = bindingInflater.invoke(inflater)
        return binding.root
    }

}