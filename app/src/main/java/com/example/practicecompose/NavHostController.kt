package com.example.practicecompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practicecompose.screens.ButtonsScreen
import com.example.practicecompose.screens.TextFieldScreen
import com.example.practicecompose.screens.TextScreen
import com.example.practicecompose.screens.sendingParameters.SendingParametersScreen1
import com.example.practicecompose.screens.sendingParameters.SendingParametersScreen2

@Composable
fun NavHostController() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable(route = SealedClassNavigation.home.route) { HomeScreen(navController) }
        composable(route = SealedClassNavigation.text.route) { TextScreen(navController) }
        composable(route = SealedClassNavigation.buttons.route) { ButtonsScreen(navController) }
        composable(route = SealedClassNavigation.textField.route) { TextFieldScreen(navController) }
        composable(route = SealedClassNavigation.sendingParameters1.route) { SendingParametersScreen1(navController) }
        composable(
            route = "sendingParameters2/{name}/{phone}",
            arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("phone") { type = NavType.IntType }
            )
            ) { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name")
            val phone = backStackEntry.arguments?.getInt("phone")

            SendingParametersScreen2(navController, name, phone) }

    }
}