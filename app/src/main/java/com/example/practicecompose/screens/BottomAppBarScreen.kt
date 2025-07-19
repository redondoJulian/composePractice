package com.example.practicecompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.DoDisturb
import androidx.compose.material.icons.filled.Draw
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomAppBarScreen(navController: NavHostController) {
    var pageSelected by remember { mutableIntStateOf(1) }
    val backgroundColor = listOf(Color.Blue, Color.Red, Color.Green, Color.Magenta, Color.White)
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("BottomNavigationBar") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.KeyboardArrowLeft,
                            contentDescription = "go back"
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = Color.Transparent,
                contentColor = Color.Black,
                modifier = Modifier.height(85.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    IconButton(onClick = { pageSelected = 1 }) {
                        Icon(
                            imageVector = Icons.Default.Draw,
                            contentDescription = null,
                            tint = if (pageSelected == 1) Color.Black else Color.LightGray
                        )
                    }
                    IconButton(onClick = { pageSelected = 2 }) {
                        Icon(
                            imageVector = Icons.Default.DoDisturb,
                            contentDescription = null,
                            tint = if (pageSelected == 2) Color.Black else Color.LightGray
                        )
                    }
                    IconButton(
                        onClick = { pageSelected = 5 },
                        modifier = Modifier
                            .size(75.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                            tint = if (pageSelected == 5) Color.Black else Color.LightGray,
                            modifier = Modifier
                                .size(50.dp)
                        )
                    }
                    IconButton(onClick = { pageSelected = 3 }) {
                        Icon(
                            imageVector = Icons.Default.Inbox,
                            contentDescription = null,
                            tint = if (pageSelected == 3) Color.Black else Color.LightGray
                        )
                    }
                    IconButton(onClick = { pageSelected = 4 }) {
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = null,
                            tint = if (pageSelected == 4) Color.Black else Color.LightGray
                        )
                    }
                }
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(backgroundColor[pageSelected - 1]),
            contentAlignment = Alignment.Center
        ) {

            Text(
                text = "$pageSelected",
                fontSize = 32.sp,
                color = Color.White
            )
        }
    }
}