package com.briceb.apicommunication.api

import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.briceb.apicommunication.R
import com.briceb.apicommunication.api.models.Item
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_question.view.*

class QuestionsAdapter (private val items: List<Item?>) : RecyclerView.Adapter<QuestionsAdapter.ViewHolder>(){
    private lateinit var mOnItemClickListener: OnItemClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_question, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(items[position])
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var txtQuestion: TextView = itemView.textQuestion
        var txtName : TextView = itemView.textName
        var txtReputation : TextView = itemView.textReputation
        var imgProfil : ImageView = itemView.imgProfil

        fun bindItems(item: Item?) {
            txtQuestion.text = Html.fromHtml( item?.title ?: "")
            txtName.text = item?.owner?.display_name
            txtReputation.text = item?.owner?.reputation.toString()
            Picasso.get().load(item?.owner?.profile_image).into(imgProfil)

            itemView.setOnClickListener { mOnItemClickListener.onItemClick(item) }
        }
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        mOnItemClickListener = onItemClickListener
    }

    interface  OnItemClickListener {
        fun onItemClick(item: Item?)
    }

    override fun getItemCount(): Int = items.size

}