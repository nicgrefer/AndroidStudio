package com.example.ejemploexamen2020

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pareja(var nombre1: String="", var nombre2: String="" ,var anos: Int) : Parcelable {

}
