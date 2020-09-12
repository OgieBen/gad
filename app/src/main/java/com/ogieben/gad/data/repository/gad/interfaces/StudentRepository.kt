package com.ogieben.gad.data.repository.gad.interfaces

import com.ogieben.gad.data.models.gad.Student
import com.ogieben.gad.data.models.gad.StudentHours
import com.ogieben.gad.data.models.gad.StudentIQ
import io.reactivex.Observable

interface StudentRepository {
    fun fetchLearningLeaders(): Observable<List<StudentHours>>
    fun fetchStudentsWithTopIQs(): Observable<List<StudentIQ>>
    fun submitProject(email: String, firstName: String, lastName: String, repoUrl: String): Observable<Any>
}