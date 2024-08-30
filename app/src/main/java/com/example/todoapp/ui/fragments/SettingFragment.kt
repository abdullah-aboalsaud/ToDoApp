package com.example.todoapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.todoapp.base.BaseFragment
import com.example.todoapp.databinding.FragmentSettingBinding
import com.example.todoapp.utils.showBottomAppBarViews

class SettingFragment : BaseFragment<FragmentSettingBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ) = FragmentSettingBinding.inflate(inflater, container, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.settingText.setOnClickListener {
            findNavController().navigate(SettingFragmentDirections.actionSettingFragmentToEditTaskFragment())
        }
    }

    override fun onResume() {
        super.onResume()
        showBottomAppBarViews()
    }
}