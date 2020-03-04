package com.briceb.learning_kotlin_android.List

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.briceb.learning_kotlin_android.R
import kotlinx.android.synthetic.main.item_contact.view.*

data class Contact(val name: String,var age: Int, val image: Int,var isActivated: Boolean)

class ContactAdapter(private val list: List<Contact>) : RecyclerView.Adapter<ContactViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ContactViewHolder(
            inflater,
            parent
        )
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

}

class ContactViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(
    R.layout.item_contact, parent, false)) {

    fun bind(contact: Contact) {
        itemView.apply {
            itemView.list_name.text = contact.name
            itemView.list_age.text = contact.age.toString()
            imgProfil.setImageDrawable(ContextCompat.getDrawable(itemView.context, contact.image))
        }
    }

}