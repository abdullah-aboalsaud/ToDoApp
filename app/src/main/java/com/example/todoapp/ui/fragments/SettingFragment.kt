package com.example.todoapp.ui.fragments

import android.content.res.Configuration.UI_MODE_NIGHT_MASK
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.todoapp.R
import com.example.todoapp.base.BaseFragment
import com.example.todoapp.databinding.FragmentSettingBinding
import com.example.todoapp.utils.DARK
import com.example.todoapp.utils.ENGLISH_CODE
import com.example.todoapp.utils.LIGHT
import com.example.todoapp.utils.applyModeChange
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

        initLanguageTvAdapter()
        initModeTvAdapter()

        onLanguageTvClick()
        onModeTvClick()

    }

    private fun onModeTvClick() {
        binding.autoCompleteTVModes.setOnItemClickListener { adapterView, view, position, id ->
            val selectedMode = adapterView.getItemAtPosition(position).toString()
            binding.autoCompleteTVModes.setText(selectedMode)
            val isDark = (selectedMode == getString(R.string.dark))
            applyModeChange(isDark)
        }
    }



    private fun onLanguageTvClick() {

    }

    private fun initLanguageTvAdapter() {
        val languages = resources.getStringArray(R.array.languages).toList()
        val languagesAdapter = ArrayAdapter(requireContext(), R.layout.drop_down_item, languages)
        binding.autoCompleteTVLanguages.setAdapter(languagesAdapter)
    }

    private fun initModeTvAdapter() {
        val modes = resources.getStringArray(R.array.modes).toList()
        val modesAdapter = ArrayAdapter(requireContext(), R.layout.drop_down_item, modes)
        binding.autoCompleteTVModes.setAdapter(modesAdapter)
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
        if (mode == LIGHT) {
            binding.modeTil.setStartIconDrawable(R.drawable.ic_light_mode)
        } else {
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