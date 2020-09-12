package com.ogieben.gad.network.handlers

import com.ogieben.gad.data.models.gad.Student
import com.ogieben.gad.data.models.gad.StudentHours
import com.ogieben.gad.data.models.gad.StudentIQ
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*


interface GADRemoteApiHandler {

    @GET("/api/hours")
    fun fetchLearningLeaders(): Observable<List<StudentHours>>

    @GET("/api/skilliq")
    fun fetchStudentsWithTopIQs(): Observable<List<StudentIQ>>
}