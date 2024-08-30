package com.example.todoapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.todoapp.database.model.Task
import com.example.todoapp.databinding.ItemTaskBinding
import com.example.todoapp.utils.formatTimeOnly

class TaskListAdapter(private var tasksList: MutableList<Task>? = null) :
    Adapter<TaskListAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasksList?.get(position)
        holder.bind(task)
    }

    override fun getItemCount() = tasksList?.size ?: 0


    fun submitNewList(tasksList: MutableList<Task>) {
        this.tasksList = tasksList
        notifyDataSetChanged()
    }

    fun addItem(newTaskItem: Task) {
        tasksList!!.add(newTaskItem)
        notifyItemInserted(tasksList!!.size)
    }

    class TaskViewHolder(val binding: ItemTaskBinding) : ViewHolder(binding.root) {
        fun bind(task: Task?) {
            binding.title.text = task?.title
            binding.time.text = task?.time?.formatTimeOnly()
        }

    }

}