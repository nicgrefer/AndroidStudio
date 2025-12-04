package com.example.ejem06_llamandoactivitys

import android.annotation.SuppressLint
import android.os.Parcel
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Usuario(val nombre:String, val edad:Int=0, val email:String="a@b.com", var soltero:Boolean=false) : Parcelable{}


