package com.example.practicecompose

sealed class SealedClassNavigation(val route: String) {
    object home : SealedClassNavigation("home")
    object text : SealedClassNavigation("text")
    object buttons : SealedClassNavigation("buttons")
    object textField : SealedClassNavigation("textField")
}