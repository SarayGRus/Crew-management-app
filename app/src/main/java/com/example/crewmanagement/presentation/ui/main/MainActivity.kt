package com.example.crewmanagement.presentation.ui.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.crewmanagement.databinding.ActivityMainBinding
import com.example.crewmanagement.domain.model.OompaLoompaListDomainResponse
import com.example.crewmanagement.presentation.base.BaseActivity
import com.example.crewmanagement.presentation.base.FailureResource
import com.example.crewmanagement.presentation.base.LoadingResource
import com.example.crewmanagement.presentation.base.SuccessResource
import com.example.crewmanagement.utils.SingleEvent
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding

    private val mainActivityViewModel: MainActivityViewModel by viewModel()
    private lateinit var oompaLoompasAdapter: OompaLoompasAdapter

    override fun observeViewModel() {
        getAllObserver()
        showToastObserver(mainActivityViewModel.showToastLiveData)
    }

    override fun initViewBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initRecycler()
        mainActivityViewModel.getAll()
    }

    private fun initRecycler() {
        val layoutManager = LinearLayoutManager(this)
        binding.rvMainOompaLoompasList.layoutManager = layoutManager
    }

    private fun showLoading(isVisible: Boolean) {
        binding.pbLoading.isVisible = isVisible
    }

    private fun bindListData(oompaLoompasList: OompaLoompaListDomainResponse) {
        if (!oompaLoompasList.results.isNullOrEmpty()) {
            oompaLoompasAdapter =
                OompaLoompasAdapter(mainActivityViewModel, oompaLoompasList.results)
            binding.rvMainOompaLoompasList.adapter = oompaLoompasAdapter
            showLoading(false)
        } else {
            showLoading(false)
        }
    }

    fun View.showToast(
        lifecycleOwner: LifecycleOwner,
        ToastEvent: LiveData<SingleEvent<Any>>,
        timeLength: Int
    ) {

        ToastEvent.observe(lifecycleOwner, Observer { event ->
            event.getContentIfNotHandled()?.let {
                when (it) {
                    is String -> Toast.makeText(this.context, it, timeLength).show()
                    is Int -> Toast.makeText(this.context, this.context.getString(it), timeLength).show()
                    else -> {
                    }
                }
            }
        })
    }

    private fun showToastObserver(event: LiveData<SingleEvent<Any>>) {
        binding.root.showToast(this, event, Snackbar.LENGTH_LONG)
    }

    private fun getAllObserver() {
        mainActivityViewModel.getAllLiveData.observe(this) { status ->
            when (status) {
                is LoadingResource -> showLoading(true)
                is SuccessResource -> status.data.let { oompaLoompas ->
                    bindListData(
                        oompaLoompasList = oompaLoompas
                    )
                }
                is FailureResource -> status.error.let { it -> mainActivityViewModel.showToastMessage(it) }
            }
        }
    }

}