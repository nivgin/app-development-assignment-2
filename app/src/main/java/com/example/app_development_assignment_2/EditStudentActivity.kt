package com.example.app_development_assignment_2

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app_development_assignment_2.databinding.EditStudentLayoutBinding
import com.example.app_development_assignment_2.model.Student
import com.example.app_development_assignment_2.model.StudentsRepository

class EditStudentActivity : AppCompatActivity() {

    private var binding: EditStudentLayoutBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.add_student_layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.addStudent)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = EditStudentLayoutBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val student: Student = StudentsRepository.instance.Students[intent.getIntExtra("student_index", 0)]

        binding?.studentNameNew?.setText(student.name)
        binding?.studentIdNew?.setText(student.id)
        binding?.studentPhoneNew?.setText(student.phone)
        binding?.studentAddressNew?.setText(student.address)
        binding?.studentCheckbox?.isChecked = student.checked

        binding?.cancelEditStudent?.setOnClickListener { view ->
            cancel(view)
        }

        binding?.deleteStudent?.setOnClickListener { view ->
            delete(view)
        }

        binding?.saveEditStudent?.setOnClickListener { view ->
            saveStudent(view)
        }
    }

    private fun saveStudent(view: View) {
        val newName = binding?.studentNameNew?.text.toString()
        val newId = binding?.studentIdNew?.text.toString()
        val newPhone = binding?.studentPhoneNew?.text.toString()
        val newAddress = binding?.studentAddressNew?.text.toString()
        val newChecked = binding?.studentCheckbox?.isChecked ?: false

        StudentsRepository.Companion.instance.Students[intent.getIntExtra("student_index", 0)] = Student(newName, newId, newPhone, newAddress, newChecked)

        finish()
    }

    private fun delete(view: View) {

        StudentsRepository.Companion.instance.Students.removeAt(intent.getIntExtra("student_index", 0))

        val intent = Intent(this, MainActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
        }
        startActivity(intent)
    }

    private fun cancel(view: View) {
        finish()
    }

}