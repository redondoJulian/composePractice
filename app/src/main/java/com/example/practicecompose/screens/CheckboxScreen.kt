package com.example.practicecompose.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.practicecompose.CodeBlock

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckboxScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Checkbox") },
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
                    var checkbox1 by rememberSaveable { mutableStateOf(false) }
                    Checkbox(
                        checked = checkbox1,
                        onCheckedChange = {
                            checkbox1 = it
                        },
                        //enabled = false
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color.Blue,
                            uncheckedColor = Color.Black,
                            checkmarkColor = Color.White
                        )
                    )

                    var checkbox2 by remember { mutableStateOf(false) }
                    Checkbox(
                        checked = checkbox2,
                        onCheckedChange = {
                            checkbox2 = it
                        },
                        //enabled = false
                        modifier = Modifier
                            .scale(2f)
                            .padding(24.dp)
                    )

                    HorizontalDivider()

                    var checkbox3 by remember { mutableStateOf(false) }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clickable{
                                checkbox3 = !checkbox3
                            }
                    ){
                        Checkbox(
                            checked = checkbox3,
                            onCheckedChange = {
                                checkbox3 = it
                            },
                            //enabled = false
                        )
                        Text("Esto es una prueba")
                        Spacer(
                            modifier = Modifier.padding(horizontal = 8.dp)
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
                        Checkbox(
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
                        colors = CheckboxDefaults.colors(
                            checkedColor = Color.Blue,
                            uncheckedColor = Color.Black,
                            checkmarkColor = Color.White
                        )
                        """.trimIndent()
                        )
                        Text(
                            "Cambio de tamaño:",
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(16.dp, 0.dp)
                        )
                        CodeBlock(
                            code = """
                        modifier = Modifier
                            .scale(2f)
                        )
                        """.trimIndent()
                        )
                    }

                }
            }
        }
    }
}