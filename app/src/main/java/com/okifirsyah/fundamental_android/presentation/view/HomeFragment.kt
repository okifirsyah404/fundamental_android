package com.okifirsyah.fundamental_android.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.okifirsyah.fundamental_android.R
import com.okifirsyah.fundamental_android.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
        get() = field!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.apply {
            btnProfile.setOnClickListener { view ->
                view.findNavController().navigate(R.id.action_homeFragment_to_profileActivity)
            }
            btnCategory.setOnClickListener{
//                Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_categoryFragment)
                findNavController().navigate(R.id.action_homeFragment_to_categoryFragment)
            }
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

}