package com.example.cupidappsergio

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cupidappsergio.databinding.ActivityMainBinding
import com.example.cupidappsergio.databinding.ItemEnamoradosBinding

class ParejaAdapter(val  listaPareja: MutableList<Pareja>) : RecyclerView.Adapter<ParejaAdapter.ParejaViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ParejaViewHolder {
       val binding= ItemEnamoradosBinding.inflate(LayoutInflater.from(parent.context))
        return ParejaViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ParejaViewHolder,
        position: Int
    ) {
       val pareja= listaPareja[position]
       holder.binding.pareja=pareja
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context,pareja.nombre1, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = listaPareja.size


    class ParejaViewHolder(val binding: ItemEnamoradosBinding): RecyclerView.ViewHolder(binding.root) {

    }
}