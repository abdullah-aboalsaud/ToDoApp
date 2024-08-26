package com.example.todoapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todoapp.base.BaseFragment
import com.example.todoapp.database.AppDatabase
import com.example.todoapp.databinding.FragmentTaskBinding
import com.example.todoapp.ui.adapters.TaskListAdapter

class TaskFragment : BaseFragment<FragmentTaskBinding>() {

    override fun inflateBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentTaskBinding.inflate(inflater, container, false)

    private val adapter = TaskListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvTasks.adapter = adapter

    }

    override fun onResume() {
        super.onResume()
        getTasksFromDatabase()
    }

    private fun getTasksFromDatabase() {
        val tasksList = AppDatabase.getInstance().tasksDao().getAllTasks()
        adapter.submitNewList(tasksList.toMutableList())

    }


}



















