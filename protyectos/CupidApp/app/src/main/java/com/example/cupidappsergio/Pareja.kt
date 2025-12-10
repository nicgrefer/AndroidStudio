package com.example.cupidappsergio

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable

data class Pareja(var nombre1:String="", var nombre2: String="", var duracion:Int=0): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre1)
        parcel.writeString(nombre2)
        parcel.writeInt(duracion)

    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "Pareja(duracion=$duracion, nombre1='$nombre1', nombre2='$nombre2')"
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
