package com.example.practicecompose.screens

import androidx.compose.foundation.background
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.practicecompose.CodeBlock

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BadgesScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Badges") },
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
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    CodeBlock("""
                        BadgedBox(
                            badge = {
                                Badge() { Text("0")}
                            }
                        ){
                            Text("Notificacion: ")
                        }
                    """.trimIndent())

                    var badgeValue by remember {
                        mutableIntStateOf(0)
                    }
                    BadgedBox(
                        badge = {
                            Badge() { Text("$badgeValue") }
                        }
                    ) {
                        IconButton(onClick = {badgeValue++}, modifier = Modifier.size(42.dp)) {
                            Icon(
                                imageVector = Icons.Default.Notifications,
                                contentDescription = "notificacion",
                                modifier = Modifier.size(32.dp)
                            )
                        }
                    }

                    Row {
                        IconButton(onClick = { badgeValue-- }) {
                            Text("-", fontSize = 30.sp)
                        }
                        ElevatedButton(onClick = { badgeValue = 0 }) { Text("Reiniciar numeros") }
                        IconButton(onClick = { badgeValue++ }) {
                            Text("+", fontSize = 18.sp)
                        }
                    }

                }

            }
        }
    }
}