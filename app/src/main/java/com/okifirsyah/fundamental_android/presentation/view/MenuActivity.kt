package com.okifirsyah.fundamental_android.presentation.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.okifirsyah.fundamental_android.R
import com.okifirsyah.fundamental_android.databinding.ActivityMainBinding
import com.okifirsyah.fundamental_android.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {

    private var _binding: ActivityMenuBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        _binding = ActivityMenuBinding.inflate(layoutInflater)

        setContentView(_binding?.root)

        with(_binding) {
            this?.searchView?.setupWithSearchBar(searchBar)

            this?.searchView
                ?.editText
                ?.setOnEditorActionListener { textView, actionId, event ->
                    this.searchBar.setText(textView.text.toString())
                    searchView.hide()
                    Toast.makeText(this@MenuActivity, searchView.text, Toast.LENGTH_SHORT).show()
                    false
                }
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
}