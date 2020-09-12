package com.ogieben.gad.data.repository.gad.student

import com.ogieben.gad.data.datasources.gad.DataSource
import com.ogieben.gad.data.datasources.gad.remote.RemoteDataSource
import com.ogieben.gad.data.models.gad.Student
import com.ogieben.gad.data.models.gad.StudentHours
import com.ogieben.gad.data.models.gad.StudentIQ
import com.ogieben.gad.data.repository.gad.interfaces.StudentRepository
import io.reactivex.Observable

class StudentRepositoryImpl(private val dataSource: RemoteDataSource) : StudentRepository {
    override fun fetchLearningLeaders(): Observable<List<StudentHours>> {
        return dataSource.fetchLearningLeaders()
    }

    override fun fetchStudentsWithTopIQs(): Observable<List<StudentIQ>> {
        return dataSource.fetchStudentsWithTopIQs()
    }

    override fun submitProject(
        email: String,
        firstName: String,
        lastName: String,
        repoUrl: String
    ): Observable<Any> {
        return dataSource.submitProject(email, firstName, lastName, repoUrl)
    }
}