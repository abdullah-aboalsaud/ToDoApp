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


    class TaskViewHolder(val binding: ItemTaskBinding) : ViewHolder(binding.root) {
        fun bind(task: Task?) {
            binding.title.text = task?.title
            binding.time.text = task?.time?.formatTimeOnly()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    var onDeleteClick: OnItemClickListener? = null
    var onItemClick: OnItemClickListener? = null
    var onDoneClick: OnItemClickListener? = null
    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasksList?.get(position)
        holder.bind(task)
        holder.binding.deleteItem.setOnClickListener {
            onDeleteClick?.onclick(task!!)
        }
        holder.binding.btnTaskIsDone.setOnClickListener {
            onDoneClick?.onclick(task!!)
        }
        holder.binding.taskItem.setOnClickListener {
            onItemClick?.onclick(task!!)
        }
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


    fun interface OnItemClickListener {
        fun onclick(task: Task)
    }

}