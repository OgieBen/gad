package com.ogieben.gad.usecases.gads.ui.home

import com.ogieben.gad.data.models.gad.Student
import com.ogieben.gad.data.repository.gad.interfaces.StudentRepository

class HomePresenter(private val productsRepository: StudentRepository): HomeContract.Actions {
    override fun fetchLearningLeader(): ArrayList<Student> {
        TODO("Not yet implemented")
    }

    override fun fetchStudentWithTopIQ(): ArrayList<Student> {
        TODO("Not yet implemented")
    }

}