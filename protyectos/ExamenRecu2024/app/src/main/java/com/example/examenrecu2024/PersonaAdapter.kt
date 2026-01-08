package com.example.examenrecu2024

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.examenrecu2024.databinding.ElementoPersoanBinding

class PersonaAdapter (val listaPersonas: List<Persona>) : RecyclerView.Adapter<PersonaAdapter.PersonaViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PersonaViewHolder {
        val binding = ElementoPersoanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PersonaViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: PersonaViewHolder,
        position: Int
    ) {
        val persona = listaPersonas[position]
        holder.binding.persona = persona
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int = listaPersonas.size

    class PersonaViewHolder (val binding: ElementoPersoanBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}