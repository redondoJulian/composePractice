package com.example.practicecompose.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.practicecompose.CodeBlock

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwitchScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Switch") },
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
            Column(Modifier.verticalScroll(rememberScrollState())) {
                var checkedValue by remember {
                    mutableStateOf(false)
                }
                Switch(
                    checked = checkedValue,
                    onCheckedChange = { checkedValue = it },
                    modifier = Modifier.padding(16.dp),
                    colors = SwitchDefaults.colors(
                        checkedThumbColor = Color.Red,
                        checkedTrackColor = Color.Blue,
                        uncheckedThumbColor = Color.Blue,
                        uncheckedTrackColor = Color.Red,
                    )
                )

                HorizontalDivider()

                var checkedValue2 by remember {
                    mutableStateOf(false)
                }
                Row(
                    modifier = Modifier
                        .clickable{
                            checkedValue2 = !checkedValue2
                        }
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Text("Disable notifications")
                    Switch(
                        checked = checkedValue2,
                        onCheckedChange = { checkedValue2 = it },
                    )
                }

                Column {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "Ejemplo de código:",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(16.dp, 0.dp)
                    )
                    CodeBlock(
                        code = """
                        Switch(
                            checked = checkedValue, (boolean)
                            onCheckedChange = { checkedValue = it },
                        )
                        """.trimIndent()
                    )
                    Text(
                        "Cambio de color:",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(16.dp, 0.dp)
                    )
                    CodeBlock(
                        code = """
                           colors = SwitchDefaults.colors(
                               checkedThumbColor = Color.Red,
                               checkedTrackColor = Color.Blue,
                               uncheckedThumbColor = Color.Blue,
                               uncheckedTrackColor = Color.Red,
                           )
                        """.trimIndent()
                    )
                }

            }

        }
    }
}