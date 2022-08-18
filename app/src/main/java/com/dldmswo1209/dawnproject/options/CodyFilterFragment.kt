package com.dldmswo1209.dawnproject.options

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import com.dldmswo1209.dawnproject.R
import com.dldmswo1209.dawnproject.databinding.FragmentCodyFilterBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CodyFilterFragment(val itemClick: (Int,Int,MutableList<String>) -> Unit) : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentCodyFilterBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_cody_filter, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCodyFilterBinding.bind(view)


        binding.confirmButton.setOnClickListener {
            val classCheckedId = binding.classRadioGroup.checkedRadioButtonId
            val sortCheckedId = binding.sortRadioGroup.checkedRadioButtonId
            val styleList = mutableListOf<String>()

            binding.apply {
                if(checkbox1.isChecked){
                    styleList.add(checkbox1.text.toString())
                }
                if(checkbox2.isChecked){
                    styleList.add(checkbox2.text.toString())
                }
                if(checkbox3.isChecked){
                    styleList.add(checkbox3.text.toString())
                }
                if(checkbox4.isChecked){
                    styleList.add(checkbox4.text.toString())
                }
                if(checkbox5.isChecked){
                    styleList.add(checkbox5.text.toString())
                }
                if(checkbox6.isChecked){
                    styleList.add(checkbox6.text.toString())
                }
                if(checkbox7.isChecked){
                    styleList.add(checkbox7.text.toString())
                }
                if(checkbox8.isChecked){
                    styleList.add(checkbox8.text.toString())
                }
            }

            itemClick(classCheckedId, sortCheckedId, styleList)
            dialog?.dismiss()
        }

    }

}