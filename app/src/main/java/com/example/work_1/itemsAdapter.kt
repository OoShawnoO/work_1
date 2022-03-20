package com.example.work_1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(val items:ArrayList<items>): RecyclerView.Adapter<ItemsAdapter.itemsViewHolder>() {
    inner class itemsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val title = itemView.findViewById<TextView>(R.id.tv1)
        val content = itemView.findViewById<TextView>(R.id.tv2)
        val image = itemView.findViewById<ImageView>(R.id.iv1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        val holder = itemsViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: itemsViewHolder, position: Int) {
        val item = items[position]
        holder.title.text = item.title
        holder.content.text = item.content
        holder.image.setImageResource(item.image)
    }

    override fun getItemCount(): Int {
        return items.size
    }

}