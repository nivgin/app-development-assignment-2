package com.example.app_development_assignment_2

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.app_development_assignment_2.databinding.ViewStudentLayoutBinding
import com.example.app_development_assignment_2.model.Student
import com.example.app_development_assignment_2.model.StudentsRepository

class ViewStudentActivity : AppCompatActivity(){

    private var binding: ViewStudentLayoutBinding? = null

    override fun onResume() {
        super.onResume()
        val index = intent.getIntExtra("student_index", 0)
        val student: Student = StudentsRepository.instance.Students[index]

        binding?.studentNameContent?.text = student.name
        binding?.studentIdContent?.text = student.id
        binding?.studentPhoneContent?.text = student.phone
        binding?.studentAddressContent?.text = student.address
        binding?.studentCheckbox?.isChecked = student.checked
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.add_student_layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.addStudent)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding = ViewStudentLayoutBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        binding?.editStudentButton?.setOnClickListener { view ->
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtras(this.intent.extras ?: Bundle())
            startActivity(intent)
        }

    }
}