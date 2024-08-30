package com.example.todoapp.ui.fragments

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.todoapp.R
import com.example.todoapp.database.AppDatabase
import com.example.todoapp.database.model.Task
import com.example.todoapp.databinding.FragmentAddTaskBinding
import com.example.todoapp.utils.formatDateOnly
import com.example.todoapp.utils.formatTimeOnly
import com.example.todoapp.utils.ignoreDate
import com.example.todoapp.utils.ignoreTime
import com.example.todoapp.utils.setDate
import com.example.todoapp.utils.setTime
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import java.util.Calendar

class AddTaskBottomSheet() : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentAddTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddTaskBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onClicks()

    }

    private fun onClicks() {
        binding.selectTimeTv.setOnClickListener {
            showTimePicker()
        }
        binding.selectDateTv.setOnClickListener {
            showDatePicker()
        }
        binding.addTaskBtn.setOnClickListener {
            createTask()
        }
    }

    fun isValidForm(): Boolean {
        var isValid = true
        if (binding.title.text.toString().isBlank()) {
            isValid = false
            // show error
            binding.titleTil.error = "Please enter title"
        } else {
            binding.titleTil.error = null
        }

        if (binding.selectDateTv.text.toString().isBlank()) {
            isValid = false
            // show error
            binding.selectDateTil.error = "Please select date"
        } else {
            binding.selectDateTil.error = null
        }


        return isValid
    }

    private fun createTask() {
        if (!isValidForm()) return
        // create task
        AppDatabase.getInstance().tasksDao()
            .createTask(
                Task(
                    title = binding.title.text.toString(),
                    description = binding.description.text.toString(),
                    date = date.timeInMillis,
                    time = time.timeInMillis,
                )
            )

        findNavController().navigate(R.id.action_addTaskBottomSheet_to_taskFragment)

    }


    val date = Calendar.getInstance().apply {
        ignoreTime()
    }
    val time = Calendar.getInstance().apply {
        ignoreDate()
    }

    private fun showDatePicker() {
        DatePickerDialog(
            requireContext(),
            DatePickerDialog.OnDateSetListener { datePicker, year, month, day ->
                date.setDate(year, month, day)
                binding.selectDateTv.text = date.formatDateOnly()
            },
            date.get(Calendar.YEAR),
            date.get(Calendar.MONTH),
            date.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    private fun showTimePicker() {
        TimePickerDialog(
            requireContext(), TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                time.setTime(hour, minute)
                binding.selectTimeTv.text = time.formatTimeOnly()

            },
            time.get(Calendar.HOUR),
            time.get(Calendar.MINUTE),
            false
        ).show()

    }


}