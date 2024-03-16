package com.okifirsyah.fundamental_android.presentation.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.okifirsyah.fundamental_android.R
import com.okifirsyah.fundamental_android.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

    var binding : ActivityProfileBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityProfileBinding.inflate(layoutInflater)

        setContentView(binding!!.root)

    }
}