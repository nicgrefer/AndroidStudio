package com.example.resuelto

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.resuelto.databinding.ItemPersonaBinding

class PersonaAdapter(val listaPersonas: MutableList<Persona>): RecyclerView.Adapter<PersonaAdapter.PersonaViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PersonaViewHolder {
        val binding = ItemPersonaBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PersonaViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: PersonaViewHolder,
        position: Int
    ) {
        val persona = listaPersonas[position]
        holder.binding.persona=persona
        holder.itemView.setOnClickListener {

            Log.d("depurando",listaPersonas[position].toString())
            notifyDataSetChanged()

        }
    }

    override fun getItemCount(): Int {
        return listaPersonas.size
    }

    class PersonaViewHolder(val binding : ItemPersonaBinding): RecyclerView.ViewHolder(binding.root) {
    }

}