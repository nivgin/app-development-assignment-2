package com.example.app_development_assignment_2.studentList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app_development_assignment_2.R
import com.example.app_development_assignment_2.databinding.StudentRowLayoutBinding
import com.example.app_development_assignment_2.model.Student

class StudentRecyclerViewAdapter(var students: MutableList<Student>?) : RecyclerView.Adapter<StudentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val binding = StudentRowLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        students?.let { holder.bind(it[position], position) }
    }

    override fun getItemCount(): Int {
        return students?.size ?: 0
    }
}