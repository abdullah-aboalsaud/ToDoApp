package com.example.todoapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todoapp.base.BaseFragment
import com.example.todoapp.databinding.FragmentEditTaskBinding
import com.example.todoapp.utils.hideBottomAppBarViews


class EditTaskFragment : BaseFragment<FragmentEditTaskBinding>() {

    override fun inflateBinding(
        inflater: LayoutInflater, container: ViewGroup?
    ) = FragmentEditTaskBinding.inflate(inflater, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        hideBottomAppBarViews()

    }

}