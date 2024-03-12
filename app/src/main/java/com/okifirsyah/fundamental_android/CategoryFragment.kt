package com.okifirsyah.fundamental_android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.okifirsyah.fundamental_android.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {

    private lateinit var binding: FragmentCategoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentCategoryBinding.inflate(inflater, container, false)
        initOnClick()

        return binding.root
    }

    private fun initOnClick() {
        binding.btnDetailCategory.setOnClickListener {


            val detailCategoryFragment = DetailCategoryFragment()
            val bundle = Bundle()
            bundle.putString(DetailCategoryFragment.EXTRA_NAME, "Lifestyle")
            val description = "Kategori ini akan berisi produk-produk lifestyle"
            detailCategoryFragment.arguments = bundle
            detailCategoryFragment.arguments?.putString(DetailCategoryFragment.EXTRA_DESCRIPTION, description)

            val fragmentManager = parentFragmentManager

            fragmentManager.beginTransaction()
                .replace(R.id.fl_main, detailCategoryFragment, DetailCategoryFragment::class.java.simpleName)
                .addToBackStack(null)
                .commit()


        }

    }


}