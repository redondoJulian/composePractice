package com.example.practicecompose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.filled.TextFields
import androidx.compose.material.icons.filled.Textsms
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Home") },
                navigationIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = (Icons.Default.Home),
                            contentDescription = "home"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Box(
                modifier = Modifier
                    .padding(10.dp, 5.dp)
                    .fillMaxSize()
            )
            {
                Column {
                    CardContent(
                        Modifier.clickable{
                            navController.navigate(SealedClassNavigation.text.route)
                        },
                        title = "Text",
                        icon = Icons.Default.TextFields
                    )
                    CardContent(
                        Modifier.clickable{
                            navController.navigate(SealedClassNavigation.buttons.route)
                        },
                        title = "Buttons",
                        icon = Icons.Default.AddCircle
                    )
                    CardContent(
                        Modifier.clickable{
                            navController.navigate(SealedClassNavigation.textField.route)
                        },
                        title = "Text Field",
                        icon = Icons.Default.Textsms
                    )
                    CardContent(
                        Modifier.clickable{
                            navController.navigate(SealedClassNavigation.sendingParameters1.route)
                        },
                        title = "Sending parameters to URL",
                        icon = Icons.Default.Send
                    )
                }
            }
        }
    }
}

@Composable
fun CardContent(modifier: Modifier, title: String, icon: ImageVector) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box() {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = title
                    )
                    Spacer(
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                    Text(
                        text = title,
                        fontSize = 21.sp,
                    )
                }
            }
            IconButton(onClick = {}) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = "go"
                )
            }
        }

    }
    HorizontalDivider()
}