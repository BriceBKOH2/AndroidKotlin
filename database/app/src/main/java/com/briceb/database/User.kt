package com.briceb.database

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.synthetic.main.item_user.view.*

@Entity
data class User(@PrimaryKey (autoGenerate = true) val id: Int,
                val name: String,
                val age: Int)
{
    constructor(name: String, age: Int): this(0,name, age)
}

class UserAdapter(private val list: MutableList<User>) : RecyclerView.Adapter<UserViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return UserViewHolder(
            inflater,
            parent
        )
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size

    fun addUser(user: User) {
        list.add(user)
        notifyItemInserted(list.size + 1)
        }

}

class UserViewHolder(inflater: LayoutInflater, parent: ViewGroup) : RecyclerView.ViewHolder(inflater.inflate(
    R.layout.item_user, parent, false)) {

    fun bind(user: User) {
        itemView.apply {
            itemView.list_name.text = user.name
            itemView.list_age.text = user.age.toString()
        }
    }

}