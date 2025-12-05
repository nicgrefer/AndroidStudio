package com.example.examenzumos

import android.os.Parcel
import android.os.Parcelable

class Zumo (var nombre : String, var precio : Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeInt(precio)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Zumo> {
        override fun createFromParcel(parcel: Parcel): Zumo {
            return Zumo(parcel)
        }

        override fun newArray(size: Int): Array<Zumo?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return "$nombre - $precio€"
    }
}