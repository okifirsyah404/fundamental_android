package com.okifirsyah.fundamental_android.presentation

import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import com.okifirsyah.fundamental_android.R
import com.okifirsyah.fundamental_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {

                val navHostFragment = supportFragmentManager.findFragmentById(binding.mainNavHost.id)
                val stack =  navHostFragment?.childFragmentManager?.backStackEntryCount

                if (stack != null && stack > 0) {
                    findNavController(binding.mainNavHost).navigateUp()
                    return
                }

                finish()
            }
        }

        this.onBackPressedDispatcher.addCallback(callback)

    }
}