package com.example.practicecompose

sealed class SealedClassNavigation(val route: String) {
    object home : SealedClassNavigation("home")
    object text : SealedClassNavigation("text")
    object buttons : SealedClassNavigation("buttons")
    object textField : SealedClassNavigation("textField")
    object sendingParameters1 : SealedClassNavigation("sendingParameters1")
    object sendingParameters2 : SealedClassNavigation("sendingParameters2/{name}/{phone}")
}