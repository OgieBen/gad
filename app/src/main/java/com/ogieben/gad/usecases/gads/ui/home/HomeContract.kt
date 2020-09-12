package com.ogieben.gad.usecases.gads.ui.home

import com.ogieben.gad.data.models.gad.Student

interface HomeContract {

    interface  View {
        fun submitProject()
    }

    interface Actions {
        fun fetchLearningLeader(): ArrayList<Student>
        fun fetchStudentWithTopIQ(): ArrayList<Student>
    }
}