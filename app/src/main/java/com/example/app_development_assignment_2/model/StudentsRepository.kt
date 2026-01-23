package com.example.app_development_assignment_2.model

import androidx.lifecycle.LiveData

class StudentsRepository private constructor() {
    val Students = mutableListOf<Student>()

    companion object {
        val instance = StudentsRepository()
    }
}