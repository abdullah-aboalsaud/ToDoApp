package com.example.todoapp.ui.fragments

import android.content.res.Configuration.UI_MODE_NIGHT_MASK
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todoapp.R
import com.example.todoapp.base.BaseFragment
import com.example.todoapp.databinding.FragmentSettingBinding
import com.example.todoapp.utils.DARK
import com.example.todoapp.utils.ENGLISH_CODE
import com.example.todoapp.utils.LIGHT
import com.example.todoapp.utils.getCurrentDeviceLanguageCode
import com.example.todoapp.utils.showBottomAppBarViews
import com.example.todoapp.utils.showToolbarSettingTitle

class SettingFragment : BaseFragment<FragmentSettingBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ) = FragmentSettingBinding.inflate(inflater, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showToolbarSettingTitle()

        setInitialLanguageState()
        setInitialModeState()


    }

    private fun setInitialModeState() {
        val currentMode = resources.configuration.uiMode and UI_MODE_NIGHT_MASK
        if (currentMode == UI_MODE_NIGHT_NO) {
            binding.autoCompleteTVModes.setText(getString(R.string.light))
            changeModeIcon(LIGHT)
        } else {
            binding.autoCompleteTVModes.setText(getString(R.string.dark))
            changeModeIcon(DARK)
        }
        binding.modeTil.refreshStartIconDrawableState()
    }

    private fun changeModeIcon(mode: String) {
        if (mode == LIGHT){
            binding.modeTil.setStartIconDrawable(R.drawable.ic_light_mode)
        }else{
            binding.modeTil.setStartIconDrawable(R.drawable.ic_dark)
        }
    }

    private fun setInitialLanguageState() {
        val currentLocaleCode = getCurrentDeviceLanguageCode(requireContext())
        val language = if (currentLocaleCode == ENGLISH_CODE)
            getString(R.string.english) else getString(R.string.arabic)
        binding.autoCompleteTVLanguages.setText(language)
    }


}