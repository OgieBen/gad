package com.ogieben.gad.network.wrappers

import com.google.gson.GsonBuilder
import com.ogieben.gad.BuildConfig
import com.ogieben.gad.network.Network
import com.ogieben.gad.network.handlers.GADRemoteApiHandler
import com.ogieben.gad.network.handlers.GoogleFormsRemoteApiHandler
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


class HttpNetworkWrapper : Network {
    private val GAD_URL = BuildConfig.GAD_URL
    private val GOOGLE_FORMS_URL = BuildConfig.GOOGLE_FORMS_URL

    private fun createGADClient(url: String): Retrofit =
        Retrofit.Builder().baseUrl(url)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .setLenient()
                        .create()
                )
            )
            .build()


    override fun initGADApiHandler(): GADRemoteApiHandler {
        val retrofit = this.createGADClient(GAD_URL)
        return retrofit.create(GADRemoteApiHandler::class.java)
    }

    override fun initGoogleFormsApiHandler(): GoogleFormsRemoteApiHandler {
        val retrofit = this.createGADClient(GOOGLE_FORMS_URL)
        return retrofit.create(GoogleFormsRemoteApiHandler::class.java)
    }
}