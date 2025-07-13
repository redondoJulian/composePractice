package com.example.practicecompose

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.practicecompose.screens.BadgesScreen
import com.example.practicecompose.screens.ButtonsScreen
import com.example.practicecompose.screens.CheckboxScreen
import com.example.practicecompose.screens.ImageScreen
import com.example.practicecompose.screens.IndicatorsScreen
import com.example.practicecompose.screens.PracticeScreen
import com.example.practicecompose.screens.RadiosScreen
import com.example.practicecompose.screens.RememberScreen
import com.example.practicecompose.screens.SliderScreen
import com.example.practicecompose.screens.SwitchScreen
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
        composable(route = SealedClassNavigation.checkbox.route) { CheckboxScreen(navController) }
        composable(route = SealedClassNavigation.switch.route) { SwitchScreen(navController) }
        composable(route = SealedClassNavigation.radios.route) { RadiosScreen(navController) }
        composable(route = SealedClassNavigation.image.route) { ImageScreen(navController) }
        composable(route = SealedClassNavigation.indicators.route) { IndicatorsScreen(navController) }
        composable(route = SealedClassNavigation.badges.route) { BadgesScreen(navController) }
        composable(route = SealedClassNavigation.slider.route) { SliderScreen(navController) }
        composable(route = SealedClassNavigation.remember.route) { RememberScreen(navController) }
        composable(route = SealedClassNavigation.practice.route) { PracticeScreen(navController) }

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