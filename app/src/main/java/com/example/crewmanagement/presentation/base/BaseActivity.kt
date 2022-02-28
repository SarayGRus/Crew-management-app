package com.example.crewmanagement.presentation.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavHost
import com.example.crewmanagement.presentation.di.injectionActivityModule
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein

abstract class BaseActivity : AppCompatActivity(), KodeinAware {

    protected abstract val layoutId: Int

    private val parentKodein by closestKodein()
    override val kodein: Kodein = Kodein.lazy {
        extend(parentKodein)
        injectActivityModule(this)?.let {
            import(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)
        onCreateActivity(savedInstanceState)
    }

    fun injectActivityModule(kodein: Kodein.MainBuilder): Kodein.Module =
        injectionActivityModule(this)

    fun onCreateActivity(savedInstanceState: Bundle?) {
    }

}
