package com.ogieben.gad.data.mock

import com.ogieben.gad.data.models.gad.Student
import com.ogieben.gad.data.models.gad.StudentHours

class StudentMock {

    companion object  {
        fun fetchProducts(): ArrayList<Student> {
            val list =  ArrayList<Student>().apply {
                add(StudentHours("Jame Doe", 24, "Nigeria", "https://res.cloudinary.com/mikeattara/image/upload/v1596700848/Top-learner.png"))
            }
            return list
        }
    }
}