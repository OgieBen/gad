package com.ogieben.gad.network

import com.ogieben.gad.network.handlers.GADRemoteApiHandler
import com.ogieben.gad.network.handlers.GoogleFormsRemoteApiHandler

interface Network {
   fun initGADApiHandler(): GADRemoteApiHandler
   fun initGoogleFormsApiHandler(): GoogleFormsRemoteApiHandler
}

