package com.example.test2

sealed class Screen(val route :String) {
    object Greeting:Screen(route = ("first screen"))
    object Screen2:Screen(route = ("second screen"))
    object Screen3:Screen(route=("third screen"))
    object Screen4:Screen(route=("fourth screen"))
    object Screen5_1:Screen(route=("fifth screen"))
    object Screen5_2:Screen(route=("sixth screen"))
    object Screen5_3:Screen(route=("seventh screen"))
    object Screen5_4:Screen(route=("eighth screen"))
    object Screen5_5:Screen(route=("ninth screen"))
    object Screen5_6:Screen(route=("tenth screen"))
    object Screen5_7:Screen(route=("eleventh screen"))
    object Screen5_8:Screen(route=("twelfth screen"))



}