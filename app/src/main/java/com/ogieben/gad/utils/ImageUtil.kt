package com.ogieben.gad.utils

import android.net.Uri
import android.view.View
import android.widget.ImageView
import com.squareup.picasso.Picasso


object ImageUtil {
    fun fetchImage(imageUri: Uri?, view: ImageView) {
        Picasso.get()
            .load(imageUri)
            .fit()
            .into(view)
    }
}