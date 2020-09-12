package com.ogieben.gad.data.models.gad

data class StudentIQ (override val name: String, val score: Int, override val country: String, override val badgeUrl: String):
    Student