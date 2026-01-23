package com.example.app_development_assignment_2.studentList

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.app_development_assignment_2.R
import com.example.app_development_assignment_2.databinding.StudentRowLayoutBinding
import com.example.app_development_assignment_2.model.Student

class StudentViewHolder (private var binding: StudentRowLayoutBinding) : RecyclerView.ViewHolder(binding.root) {

    private var student: Student? = null

    init {
        binding.checkbox.setOnClickListener {
            view -> (view?.tag as? Int)?.let {
                student?.checked = (view as? CheckBox)?.isChecked ?: false
            }
        }
    }

    fun bind(student: Student, position: Int) {
        this.student = student
        binding.studentName.text = student.name
        binding.studentId.text = student.id
        binding.checkbox.apply { isChecked = student.checked }
    }
}