package com.okifirsyah.fundamental_android

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.okifirsyah.fundamental_android.databinding.FragmentOptionDialogBinding


class OptionDialogFragment : DialogFragment() {

    interface OnOptionDialogListener {
        fun onOptionChosen(text: String?)
    }

    private lateinit var binding: FragmentOptionDialogBinding

    private lateinit var optionDialogListener: OnOptionDialogListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOptionDialogBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initOnClick()
    }

    private fun initOnClick() {
        binding.btnChoose.setOnClickListener {

            val checkRadioButtonId = binding.rgOptions.checkedRadioButtonId

            if (checkRadioButtonId != -1) {
                val selectedCoach: String? = when (checkRadioButtonId) {
                    binding.rbSaf.id -> binding.rbSaf.text.toString().trim()
                    binding.rbLvg.id -> binding.rbLvg.text.toString().trim()
                    binding.rbMou.id -> binding.rbMou.text.toString().trim()
                    binding.rbMoyes.id -> binding.rbMoyes.text.toString().trim()
                    else -> null
                }

                optionDialogListener.onOptionChosen(selectedCoach)

                dialog?.dismiss()
            }

        }

        binding.btnClose.setOnClickListener{
            dialog?.cancel()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val fragment = parentFragment

        if (fragment is DetailCategoryFragment) optionDialogListener = fragment.optionDialogListener

    }


}