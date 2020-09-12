package com.ogieben.gad.di.modules


import com.ogieben.gad.data.datasources.gad.remote.RemoteDataSource
import com.ogieben.gad.data.datasources.gad.remote.RemoteDataSourceImpl
import com.ogieben.gad.data.repository.gad.interfaces.StudentRepository
import com.ogieben.gad.data.repository.gad.student.StudentRepositoryImpl
import com.ogieben.gad.network.Network
import com.ogieben.gad.network.wrappers.HttpNetworkWrapper
import com.ogieben.gad.usecases.gads.adapters.GadsAdapter
import com.ogieben.gad.usecases.gads.ui.home.HomeContract
import com.ogieben.gad.usecases.gads.ui.home.HomePresenter

import org.koin.dsl.module

val appModule = module {

//    single<Network> {
//        HttpNetworkWrapper()
//    }
//
//    single<RemoteDataSource> {
//        RemoteDataSourceImpl(get())
//    }
//
//    single<StudentRepository> {
//        StudentRepositoryImpl(get())
//    }
//    single<HomeContract.Actions> {
//        HomePresenter(get())
//    }
//    single {
//        GadsAdapter(ArrayList(0))
//    }
}