package com.example.blancojoseluis

import android.os.Parcel
import android.os.Parcelable

class Persona (val nombre: String, val Edad: String): Parcelable {


    override fun toString(): String {
        return nombre
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel, p1: Int) {
        TODO("Not yet implemented")
    }
}