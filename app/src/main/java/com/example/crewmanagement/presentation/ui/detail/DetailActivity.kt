package com.example.crewmanagement.presentation.ui.detail

import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crewmanagement.R
import com.example.crewmanagement.databinding.ActivityDetailBinding
import com.example.crewmanagement.databinding.ActivityMainBinding
import com.example.crewmanagement.domain.model.OompaLoompaDomain
import com.example.crewmanagement.domain.model.OompaLoompaListDomainResponse
import com.example.crewmanagement.presentation.base.BaseActivity
import com.example.crewmanagement.presentation.base.FailureResource
import com.example.crewmanagement.presentation.base.LoadingResource
import com.example.crewmanagement.presentation.base.SuccessResource
import com.example.crewmanagement.utils.OOMPA_LOOMPA_ID
import com.example.crewmanagement.utils.SingleEvent
import com.example.crewmanagement.utils.checknull
import com.google.android.material.snackbar.Snackbar
import com.squareup.picasso.Picasso
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : BaseActivity() {
    private lateinit var binding: ActivityDetailBinding

    private val detailActivityViewModel: DetailActivityViewModel by viewModel()

    override fun observeViewModel() {
        getDetailObserver()
    }

    override fun initViewBinding() {
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        detailActivityViewModel.initIntentData((intent.getSerializableExtra(OOMPA_LOOMPA_ID) as OompaLoompaDomain))
        detailActivityViewModel.getDetail(detailActivityViewModel.oompaLoompaSelected.value?.id.checknull())
        initListeners()
    }

    private fun initListeners() {
        binding.ivDetailClose.setOnClickListener { navigateBack() }
    }

    private fun navigateBack() {
        finish()
    }

    private fun showLoading(isVisible: Boolean) {
        binding.pbLoading.isVisible = isVisible
    }

    private fun bindData(oompaLoompa: OompaLoompaDomain) {
        binding.tvDetailScreenTitle.text = getString(
            R.string.oompa_loompa_detail_name,
            oompaLoompa.firstName,
            oompaLoompa.lastName
        )
        binding.root.context.getDrawable(R.drawable.ic_user_default)?.let {
            Picasso.get().load(oompaLoompa.image).placeholder(it)
                .into(binding.ivOompaLoompasListItem)
        }
        binding.tvOompaLoompasListItemName.text = getString(
            R.string.oompa_loompa_item_name, oompaLoompa.firstName, oompaLoompa.lastName
        )
        binding.tvOompaLoompasListItemAge.text = getString(
            R.string.oompa_loompa_item_age,
            oompaLoompa.age.toString()
        )
        binding.tvOompaLoompasListItemCountry.text = oompaLoompa.country
        binding.tvOompaLoompasListItemGender.text = getString(
            R.string.oompa_loompa_item_gender,
            oompaLoompa.gender
        )
        binding.tvOompaLoompasListItemProfession.text = oompaLoompa.profession
        binding.tvOompaLoompasListItemEmail.text = oompaLoompa.email
        binding.tvDetailDescriptionValue.text = Html.fromHtml(oompaLoompa.description)
        binding.tvDetailFavoriteColor.text = getString(R.string.oompa_loompa_detail_favorite_color,oompaLoompa.favorite?.color)
        binding.tvDetailFavoriteFood.text = getString(R.string.oompa_loompa_detail_favorite_food,oompaLoompa.favorite?.food)
        showLoading(false)
    }

    private fun getDetailObserver() {
        detailActivityViewModel.getDetailLiveData.observe(this) { status ->
            when (status) {
                is LoadingResource -> showLoading(true)
                is SuccessResource -> status.data.let { oompaLoompa ->
                    bindData(oompaLoompa = oompaLoompa)
                }
                is FailureResource -> status.error.let { detailActivityViewModel.showToastMessage(it) }
            }

        }
    }
}