package com.okifirsyah.fundamental_android

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.okifirsyah.fundamental_android.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragmentManager = supportFragmentManager
        val homeFragment = HomeFragment()
        val fragmentTransaction = fragmentManager.findFragmentByTag(HomeFragment::class.java.simpleName)

        if (fragmentTransaction !is HomeFragment) {
            fragmentManager.beginTransaction()
                .add(R.id.fl_main, homeFragment, HomeFragment::class.java.simpleName)
                .commit()
        }

    }
}