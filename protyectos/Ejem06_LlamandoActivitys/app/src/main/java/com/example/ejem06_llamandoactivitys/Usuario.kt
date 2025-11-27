package com.example.ejem06_llamandoactivitys

import android.os.Parcel
import android.os.Parcelable
import android.annotation.SuppressLint

data class Usuario(
    val nombre: String,
    val edad: Int = 0,
    val email: String = "a@b.com"
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",
        parcel.readInt(),
        parcel.readString() ?: "a@b.com"
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeInt(edad)
        parcel.writeString(email)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Usuario> {
        override fun createFromParcel(parcel: Parcel): Usuario = Usuario(parcel)
        override fun newArray(size: Int): Array<Usuario?> = arrayOfNulls(size)
    }

    @SuppressLint("DefaultLocale")
    override fun toString(): String {
        return "Nombre: ${nombre}, Edad: ${edad}, Email: ${email}"
    }
}
