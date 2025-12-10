package com.example.ejemploexamen2020

import android.os.Parcel
import android.os.Parcelable

data class Pareja(var nombre1: String="", var nombre2: String="" ,var anos: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(p0: Parcel, p1: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<Pareja> {
        override fun createFromParcel(parcel: Parcel): Pareja {
            return Pareja(parcel)
        }

        override fun newArray(size: Int): Array<Pareja?> {
            return arrayOfNulls(size)
        }
    }
}
