package com.example.crewmanagement.presentation.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import com.example.crewmanagement.R
import com.example.crewmanagement.databinding.ActivitySplashBinding
import com.example.crewmanagement.databinding.ItemOompaloompasListBinding
import com.example.crewmanagement.presentation.base.BaseActivity
import com.example.crewmanagement.presentation.ui.main.MainActivity

class SplashActivity : BaseActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun observeViewModel() {}

    override fun initViewBinding() {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navigateToMainScreen()
    }

    private fun navigateToMainScreen() {
        Handler().postDelayed({
            val nextScreenIntent = Intent(this, MainActivity::class.java)
            startActivity(nextScreenIntent)
            finish()
        }, SPLASH_DELAY)
    }

    private companion object {
        const val SPLASH_DELAY = 3000L
    }
}