package com.example.practicecompose.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FilledTonalIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ButtonsScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Buttons") },
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
                Column(Modifier.verticalScroll(rememberScrollState())) {
                    Button(
                        onClick = {}
                    ) { Text("Button normal") }
                    ElevatedButton(
                        onClick = {}
                    ) { Text("Elevated Button") }
                    OutlinedButton(
                        onClick = {}
                    ) { Text("OutlinedButton") }
                    FilledTonalButton(
                        onClick = {}
                    ) { Text("Filled Tonal Button") }
                    FilledTonalIconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Default.AddCircle,
                            contentDescription = "",
                            tint = Color.White
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text("Button")
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White,
                            containerColor = Color.Blue
                        )
                    ) { Text("Button normal") }

                    Text("Elevated button")
                    ElevatedButton(
                        onClick = {},
                        modifier = Modifier.fillMaxWidth(),
                        elevation = ButtonDefaults.elevatedButtonElevation(
                            defaultElevation = 5.dp,
                            hoveredElevation = 10.dp,
                            pressedElevation = 8.dp
                        )
                    ) { Text("Elevated Button") }

                    ElevatedButton(
                        onClick = {},
                        enabled = false,
                        modifier = Modifier.fillMaxWidth(),
                        elevation = ButtonDefaults.elevatedButtonElevation(
                            defaultElevation = 5.dp,
                            hoveredElevation = 10.dp,
                            pressedElevation = 8.dp
                        )
                    ) { Text("Elevated Button disabled") }

                    Text("Outlined button")
                    OutlinedButton(
                        onClick = {},
                        border = BorderStroke(2.dp, Color.Black),
                    ) { Text("OutlinedButton") }
                }
            }
        }
    }
}