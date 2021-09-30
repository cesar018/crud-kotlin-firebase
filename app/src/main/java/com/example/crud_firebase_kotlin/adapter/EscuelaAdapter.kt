package com.example.crud_firebase_kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_firebase_kotlin.EscuelaListActivity
import com.example.crud_firebase_kotlin.R
import com.example.crud_firebase_kotlin.model.Escuela

class EscuelaAdapter(private val escuelaListActivity: ArrayList<Escuela>) : RecyclerView.Adapter<EscuelaAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.escuela_item,
        parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = escuelaListActivity[position]
        holder.nombre.text = currentitem.nombre
        holder.facultad.text = currentitem.facultad
    }

    override fun getItemCount(): Int {
        return escuelaListActivity.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val nombre : TextView = itemView.findViewById(R.id.tvnombre_esc)
        val facultad : TextView = itemView.findViewById(R.id.tvfacultad)
    }
}