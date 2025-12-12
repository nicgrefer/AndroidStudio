package com.example.ejer09_aplicacionllamadas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(
    private val contactos: List<Contacto>,
    private val onClick: (Contacto) -> Unit
) : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNombre: TextView = itemView.findViewById(R.id.tv_nombre)
        val tvNumero: TextView = itemView.findViewById(R.id.tv_numero)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.estilo_contactos, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = contactos.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contacto = contactos[position]
        holder.tvNombre.text = contacto.nombre
        holder.tvNumero.text = contacto.numero

        holder.itemView.setOnClickListener {
            onClick(contacto)
        }
    }
}
