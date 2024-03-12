package com.okifirsyah.fundamental_android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.okifirsyah.fundamental_android.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        initOnClick()
        return binding.root
    }

    private fun initOnClick() {
        binding.btnCategory.setOnClickListener {
            val categoryFragment = CategoryFragment()

            val fragmentManager = parentFragmentManager

            fragmentManager.beginTransaction()
                .replace(R.id.fl_main, categoryFragment, CategoryFragment::class.java.simpleName)
                .addToBackStack(null)
                .commit()
        }
    }


}