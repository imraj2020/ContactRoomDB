package com.cse.contactroomdb.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cse.contactroomdb.models.Contact
import com.cse.contactroomdb.databinding.ItemContactBinding
import javax.inject.Inject

//Question Here
//import androidx.recyclerview.widget.RecyclerView.Adapter


class ContactAdapter @Inject constructor(
    private var contactlist: List<Contact>,
    private var listener: Listener
) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    interface Listener {

        fun contactclick(contact: Contact)
    }


    inner class ContactViewHolder(val binding: ItemContactBinding) :
        RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {

        val contactViewHolder = ContactViewHolder(
            ItemContactBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent,
                false
            )
        )

        return contactViewHolder
    }

    override fun getItemCount(): Int {
        return contactlist.size
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {

        val contact = contactlist[position]

        holder.binding.nameTv.text = contact.name
        holder.binding.emailTv.text = contact.email
        holder.binding.mobileTv.text = contact.phone

        holder.itemView.setOnClickListener(View.OnClickListener {
            listener.contactclick(contact)
        })


    }


}