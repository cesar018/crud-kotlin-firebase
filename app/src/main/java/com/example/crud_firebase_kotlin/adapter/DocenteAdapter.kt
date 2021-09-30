package com.example.crud_firebase_kotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.crud_firebase_kotlin.DocenteListActivity
import com.example.crud_firebase_kotlin.R
import com.example.crud_firebase_kotlin.model.Docente

class DocenteAdapter(private var docenteListActivity: ArrayList<Docente>) : RecyclerView.Adapter<DocenteAdapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.docente_item,
            parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentitem = docenteListActivity[position]
        holder.codigo.text = currentitem.codigo
        holder.nombre.text = currentitem.nombre
        holder.dni.text = currentitem.dni
        holder.telefono.text = currentitem.telefono
        holder.correo.text = currentitem.correo
    }

    override fun getItemCount(): Int {
        return docenteListActivity.size
    }
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val codigo : TextView = itemView.findViewById(R.id.tvcodigo)
        val nombre : TextView = itemView.findViewById(R.id.tvnombre_doc)
        val dni : TextView = itemView.findViewById(R.id.tvdni)
        val telefono : TextView = itemView.findViewById(R.id.tvtelefono)
        val correo : TextView = itemView.findViewById(R.id.tvcorreo)
    }
}