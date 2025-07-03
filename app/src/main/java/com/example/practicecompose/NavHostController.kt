package com.example.practicecompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practicecompose.screens.ButtonsScreen
import com.example.practicecompose.screens.TextFieldScreen
import com.example.practicecompose.screens.TextScreen

@Composable
fun NavHostController() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable(route = SealedClassNavigation.home.route) { HomeScreen(navController) }
        composable(route = SealedClassNavigation.text.route) { TextScreen(navController) }
        composable(route = SealedClassNavigation.buttons.route) { ButtonsScreen(navController) }
        composable(route = SealedClassNavigation.textField.route) { TextFieldScreen(navController) }

    }
}