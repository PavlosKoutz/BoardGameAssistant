package com.example.test2

import android.os.Parcelable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize

@Parcelize
data class Register(
    var Name: String,
    var MoneyValue: Int = 0,


) : Parcelable {

    @IgnoredOnParcel
    val Money: MutableState<Int> = mutableStateOf(MoneyValue)




    override fun toString(): String {
        return "Register(Name='$Name', MoneyValue=$MoneyValue)"
    }
}
data class ItemWithCounters(
    val name: String,
    var houses: MutableState<Int> = mutableStateOf(0),
    var hotels: MutableState<Int> = mutableStateOf(0),

)

