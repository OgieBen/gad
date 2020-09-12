package com.ogieben.gad.data.datasources.gad.remote

import com.ogieben.gad.data.datasources.gad.DataSource
import com.ogieben.gad.data.models.gad.Student
import com.ogieben.gad.data.models.gad.StudentHours
import com.ogieben.gad.data.models.gad.StudentIQ
import com.ogieben.gad.network.Network
import io.reactivex.Observable

class RemoteDataSourceImpl(remoteApi: Network): RemoteDataSource {
    private val gadApiHandler = remoteApi.initGADApiHandler()
    private val gfApiHandler = remoteApi.initGoogleFormsApiHandler()

    override fun fetchLearningLeaders(): Observable<List<StudentHours>> {
        return gadApiHandler.fetchLearningLeaders()
    }

    override fun fetchStudentsWithTopIQs(): Observable<List<StudentIQ>> {
        return gadApiHandler.fetchStudentsWithTopIQs()
    }

    override fun submitProject(
        email: String,
        firstName: String,
        lastName: String,
        repoUrl: String
    ): Observable<Any> {
        return gfApiHandler.submitProject(email, firstName, lastName, repoUrl)
    }
}