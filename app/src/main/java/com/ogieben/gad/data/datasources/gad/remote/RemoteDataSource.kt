package com.ogieben.gad.data.datasources.gad.remote

import com.ogieben.gad.data.datasources.gad.DataSource
import io.reactivex.Observable

interface RemoteDataSource: DataSource {
    fun submitProject(email: String, firstName: String, lastName: String, repoUrl: String): Observable<Any>
}