package com.example.ejemplotipoexamen

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(var user:String, var pass:String):Parcelable
