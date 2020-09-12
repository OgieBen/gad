package com.ogieben.gad.data.datasources.gad

import com.ogieben.gad.data.models.gad.StudentHours
import com.ogieben.gad.data.models.gad.StudentIQ
import io.reactivex.Observable


interface DataSource {
    fun fetchLearningLeaders(): Observable<List<StudentHours>>
    fun fetchStudentsWithTopIQs(): Observable<List<StudentIQ>>
}