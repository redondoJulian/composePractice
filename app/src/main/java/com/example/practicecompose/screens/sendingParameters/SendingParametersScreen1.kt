package com.example.practicecompose.screens.sendingParameters

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
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
import com.example.practicecompose.SealedClassNavigation

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
                            imageVector = Icons.Default.KeyboardArrowLeft,
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