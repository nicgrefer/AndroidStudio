package com.example.ejemplotipoexamen

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Zumo(val nombre:String, val precio: Int): Parcelable
