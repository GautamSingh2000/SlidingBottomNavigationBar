package com.example.appsinvotask.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.appsinvotask.R
import com.example.appsinvotask.model.single_tab

class singleTab_adapter(
    val context : Context,
    val list : ArrayList<single_tab> = ArrayList()
): RecyclerView.Adapter<singleTab_adapter.viewHolder>() {

    class viewHolder(itemView: View):ViewHolder(itemView)
    {
        val image : ImageView = itemView.findViewById(R.id.image)
        val heading : TextView = itemView.findViewById(R.id.text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view =  LayoutInflater.from(parent.context)
            .inflate(R.layout.single_tab, parent, false)
      return viewHolder(view)
    }

    override fun getItemCount(): Int {
      return list.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val data = list.get(position)
        Glide.with(context).load(data.image).placeholder(R.drawable.ic_logo_color).into(holder.image)
        holder.heading.text = data.name
    }
}