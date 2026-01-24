package com.example.app_development_assignment_2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app_development_assignment_2.databinding.AddStudentLayoutBinding
import com.example.app_development_assignment_2.databinding.StudentRowLayoutBinding
import com.example.app_development_assignment_2.model.Student
import com.example.app_development_assignment_2.model.StudentsRepository

class AddStudentActivity : AppCompatActivity() {

    private var binding: AddStudentLayoutBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.add_student_layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.addStudent)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = AddStudentLayoutBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.cancelAddStudent?.setOnClickListener { view ->
            cancel(view)
        }

        binding?.saveNewStudent?.setOnClickListener { view ->
            saveStudent(view)
        }
    }

    private fun saveStudent(view: View) {
        val name = binding?.studentNameNew?.text.toString()
        val id = binding?.studentIdNew?.text.toString()
        val phone = binding?.studentPhoneNew?.text.toString()
        val address = binding?.studentAddressNew?.text.toString()
        val checked = binding?.studentCheckbox?.isChecked ?: false
        
        StudentsRepository.instance.Students.add(Student(name, id, phone, address, checked))
        finish()
    }

    private fun cancel(view: View) {
        finish()
    }
}