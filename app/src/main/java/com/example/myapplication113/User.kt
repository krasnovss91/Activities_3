package com.example.myapplication113

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(val firstName: String, val lastName: String, val workInfo: String):Parcelable
