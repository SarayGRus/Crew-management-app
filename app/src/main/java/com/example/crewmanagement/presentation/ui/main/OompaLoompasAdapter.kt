package com.example.crewmanagement.presentation.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crewmanagement.databinding.ItemOompaloompasListBinding
import com.example.crewmanagement.domain.model.OompaLoompaDomain

class OompaLoompasAdapter(private val mainActivityViewModel: MainActivityViewModel, private val oompaLoompas: List<OompaLoompaDomain>) : RecyclerView.Adapter<OompaLoompaViewHolder>() {

    private val onItemClickListener: RecyclerItemListener = object : RecyclerItemListener {
        override fun onItemSelected(recipe: OompaLoompaDomain) {
            //mainActivityViewModel.openRecipeDetails(recipe)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OompaLoompaViewHolder {
        val itemBinding = ItemOompaloompasListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return OompaLoompaViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: OompaLoompaViewHolder, position: Int) {
        holder.bind(oompaLoompas[position], onItemClickListener)
    }

    override fun getItemCount(): Int {
        return oompaLoompas.size
    }
}

interface RecyclerItemListener {
    fun onItemSelected(recipe : OompaLoompaDomain)
}

