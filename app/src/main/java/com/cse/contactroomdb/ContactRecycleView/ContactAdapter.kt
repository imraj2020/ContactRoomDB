package com.cse.contactroomdb.ContactRecycleView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import androidx.recyclerview.widget.RecyclerView
import com.cse.contactroomdb.Contact
import com.cse.contactroomdb.databinding.ItemContactBinding

class ContactAdapter(val contactlist: List<Contact>, var listener: ContactAdapter.Listener) :
    RecyclerView.Adapter<ContactViewHolder>() {
    interface Listener {

        fun contactclick(contact: Contact)
    }

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