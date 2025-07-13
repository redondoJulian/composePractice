package com.example.practicecompose

sealed class SealedClassNavigation(val route: String) {
    object remember : SealedClassNavigation("remember")
    object practice : SealedClassNavigation("practice")
    object home : SealedClassNavigation("home")
    object text : SealedClassNavigation("text")
    object buttons : SealedClassNavigation("buttons")
    object textField : SealedClassNavigation("textField")
    object sendingParameters1 : SealedClassNavigation("sendingParameters1")
    object sendingParameters2 : SealedClassNavigation("sendingParameters2/{name}/{phone}")
    object checkbox : SealedClassNavigation("checkbox")
    object switch : SealedClassNavigation("switch")
    object radios : SealedClassNavigation("radios")
    object image : SealedClassNavigation("image")
    object indicators : SealedClassNavigation("indicators")
    object badges : SealedClassNavigation("badges")
    object slider : SealedClassNavigation("slider")
}