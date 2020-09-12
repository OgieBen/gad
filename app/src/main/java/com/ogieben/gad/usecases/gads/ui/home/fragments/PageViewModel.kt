package com.ogieben.gad.usecases.gads.ui.home.fragments

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.ogieben.gad.data.models.gad.Student
import com.ogieben.gad.data.repository.gad.interfaces.StudentRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class PageViewModel : ViewModel() {

    private val _index = MutableLiveData<Int>()
    val students = MutableLiveData<List<Student>>();

    fun setIndex(index: Int) {
        _index.value = index
    }

    fun fetchLearningLeaders(studentRepository: StudentRepository) {
        studentRepository
            .fetchLearningLeaders()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                students.value = it
            },{
                Log.e(this::class.java.simpleName, it.message.toString())
            })
    }

    fun fetchStudentsWithTopIQs(studentRepository: StudentRepository) {
        studentRepository
            .fetchStudentsWithTopIQs()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                students.value = it
            },{
                Log.e(this::class.java.simpleName, it.message.toString())
            })
    }
}