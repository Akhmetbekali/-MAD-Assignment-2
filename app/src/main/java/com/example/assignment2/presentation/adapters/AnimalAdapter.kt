package com.example.assignment2.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.assignment2.R
import com.example.assignment2.data.Animal
import kotlinx.android.synthetic.main.animals_list_item_view.view.*

class AnimalAdapter(private val cellClickListener: OnAnimalItemClickListener): ListAdapter<String, AnimalViewHolder>(Animal.DIFF_CALLBACK){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.animals_list_item_view, parent,false)
        return AnimalViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        val data = getItem(position)
        holder.bind(data)
        holder.itemView.setOnClickListener {
            cellClickListener.onCellClickListener(data)
        }
    }
}


class AnimalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(link: String) {
        Glide.with(itemView).load(link).into(itemView.dog_image)
    }
}

interface OnAnimalItemClickListener {
    fun onCellClickListener(data: String)

}
