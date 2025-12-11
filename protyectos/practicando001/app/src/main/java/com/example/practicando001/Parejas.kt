package com.example.practicando001

import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Parejas(val nomnre1: String="", val nombre2: String="",val duracion: Int=0) : Parcelable {

    override fun toString(): String {
        return nomnre1+" ,"+nombre2+" durante "+duracion+" años"
    }

}

