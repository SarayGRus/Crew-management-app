package com.example.crewmanagement.presentation.ui.main

import androidx.recyclerview.widget.RecyclerView
import com.example.crewmanagement.R
import com.example.crewmanagement.databinding.ItemOompaloompasListBinding
import com.example.crewmanagement.domain.model.OompaLoompaDomain
import com.squareup.picasso.Picasso

class OompaLoompaViewHolder(private val itemBinding: ItemOompaloompasListBinding) :
    RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(oompaLoompasItem: OompaLoompaDomain, recyclerItemListener: RecyclerItemListener) {
        itemBinding.root.context.getDrawable(R.drawable.ic_user_default)?.let {
            Picasso.get().load(oompaLoompasItem.image).placeholder(it)
                .into(itemBinding.ivOompaLoompasListItem)
        }
        itemBinding.tvOompaLoompasListItemName.text = itemBinding.root.context.getString(
            R.string.oompa_loompa_item_name, oompaLoompasItem.firstName, oompaLoompasItem.lastName
        )
        itemBinding.tvOompaLoompasListItemAge.text = itemBinding.root.context.getString(
            R.string.oompa_loompa_item_age,
            oompaLoompasItem.age.toString()
        )
        itemBinding.tvOompaLoompasListItemCountry.text = oompaLoompasItem.country
        itemBinding.tvOompaLoompasListItemGender.text = itemBinding.root.context.getString(
            R.string.oompa_loompa_item_gender,
            oompaLoompasItem.gender
        )
        itemBinding.tvOompaLoompasListItemProfession.text = oompaLoompasItem.profession
        itemBinding.tvOompaLoompasListItemEmail.text = oompaLoompasItem.email
        itemBinding.cvOompaLoompasItem.setOnClickListener {
            recyclerItemListener.onItemSelected(
                oompaLoompasItem
            )
        }
    }
}

