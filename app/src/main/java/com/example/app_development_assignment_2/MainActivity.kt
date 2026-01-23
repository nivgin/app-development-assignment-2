package com.example.app_development_assignment_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.app_development_assignment_2.model.Student
import com.example.app_development_assignment_2.studentList.StudentRecyclerViewAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val tempStudents: MutableList<Student> = listOf(
            Student(
                name = "Alice Johnson",
                id = "S001",
                phone = "123-456-7890",
                address = "123 Maple Street",
                checked = false
            ),
            Student(
                name = "Bob Smith",
                id = "S002",
                phone = "234-567-8901",
                address = "456 Oak Avenue",
                checked = true
            ),
            Student(
                name = "Charlie Brown",
                id = "S003",
                phone = "345-678-9012",
                address = "789 Pine Lane",
                checked = false
            )
        ) as MutableList<Student>


        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val studentsView = findViewById<RecyclerView>(R.id.RecyclerView)
        studentsView.setHasFixedSize(true)
        studentsView.layoutManager = LinearLayoutManager(this)
        //val students = StudentsRepository.instance.Students
        val students = tempStudents
        val adapter = StudentRecyclerViewAdapter(students)
        studentsView.adapter = adapter

        val addStudent = findViewById<Button>(R.id.add_student_button)
        addStudent.setOnClickListener {
            startActivity(Intent(this, AddStudentActivity::class.java))
        }
    }
}