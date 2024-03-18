package com.okifirsyah.fundamental_android

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.okifirsyah.fundamental_android.databinding.ActivityMainBinding
import com.okifirsyah.fundamental_android.presentation.view.MenuActivity
import com.okifirsyah.fundamental_android.presentation.view.MenuFragment

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(_binding?.root)

        _binding?.topAppBar?.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu1 -> {
                    _binding?.fragmentContainer?.id?.let {
                        supportFragmentManager.beginTransaction().replace(
                            it, MenuFragment()).addToBackStack(null).commit()
                    }
                    true
                }
                R.id.menu2 -> {
                    startActivity(Intent(this, MenuActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}