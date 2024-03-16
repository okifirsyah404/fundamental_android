package com.okifirsyah.fundamental_android.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.okifirsyah.fundamental_android.R
import com.okifirsyah.fundamental_android.databinding.FragmentCategoryBinding


class CategoryFragment : Fragment() {

    private var _binding : FragmentCategoryBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCategoryBinding.inflate(inflater, container, false);
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.apply {
            btnCategoryLifestyle.setOnClickListener {
                val data = Bundle()
                data.putString(DetailCategoryFragment.EXTRA_NAME, "Lifecycle")
                data.putInt(DetailCategoryFragment.EXTRA_STOCK, 8)

                findNavController().navigate(R.id.action_categoryFragment_to_detailCategoryFragment, data)
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
    }


}