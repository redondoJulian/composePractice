package com.example.practicecompose.screens.sendingParameters

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.practicecompose.CodeBlock


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SendingParametersScreen1(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Sending Parameters") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                            contentDescription = "go back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Box(
                modifier = Modifier
                    .padding(15.dp, 10.dp)
                    .fillMaxSize(),
            ) {
                Column {
                    CardProfile("Julian", 1160476405, navController)
                    CardProfile("Jesica", 1160476403, navController)
                    CardProfile("Jesus", 1160456405, navController)
                    CardProfile("Kukita", 1166476402, navController)

                    Column {
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            "Ejemplo de NavHostController():",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(16.dp, 0.dp)
                        )
                        CodeBlock(
                            code = """
                            composable(
                                 route = "sendingParameters2/{name}/{phone}",
                                 arguments = listOf(
                                       navArgument("name") { type = NavType.StringType },
                                       navArgument("phone") { type = NavType.IntType }
                                       )
                            ) { backStackEntry ->
                                 val name = backStackEntry.arguments?.getString("name")
                                 val phone = backStackEntry.arguments?.getInt("phone")
                            
                                 SendingParametersScreen2(navController, name, phone) 
                            }
                        """.trimIndent()
                        )
                        Text(
                            "Ejemplo de CardProfile():",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(16.dp, 0.dp)
                        )
                        CodeBlock(
                            code = """
                        modifier = Modifier
                            .clickable{
                                navController.navigate("sendingParameters2/$ name/$ phone")
                            }
                        """.trimIndent()
                        )

                    }
                }
            }
        }
    }
}

@Composable
fun CardProfile(name: String, phone: Int, navController: NavHostController) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .clickable{
                navController.navigate("sendingParameters2/$name/$phone")
            }
            .padding(10.dp)
            .fillMaxWidth()
    ) {
        Text(text = name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Text(text = phone.toString(),  fontSize = 19.sp, fontWeight = FontWeight.Thin)
    }
}