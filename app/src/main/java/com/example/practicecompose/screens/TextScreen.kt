package com.example.practicecompose.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
fun TextScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Text") },
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
                Column() {
                    Text(
                        text = buildAnnotatedString {
                            append("Hola soy ")
                            withStyle(
                                style = SpanStyle(
                                    fontWeight = FontWeight.Bold
                                )
                            ) { append("Julian") }
                            append(" y soy un ")
                            withStyle(
                                style = SpanStyle(
                                    color = Color.Blue
                                )
                            ) { append("CRACK") }
                        },
                        fontSize = 22.sp
                    )
                }

                Column {
                    Spacer(modifier = Modifier.padding(vertical = 16.dp))
                    Text(
                        "Ejemplo de código:",
                        fontWeight = FontWeight.Bold,
                    )
                    CodeBlock(
                        code = """
                            Text(
                                text = buildAnnotatedString {
                                
                                    append("Hola soy ")
                                    
                                    withStyle(
                                        style = SpanStyle(
                                            fontWeight = FontWeight.Bold
                                        )
                                    ) { append("Julian") }
                                    
                                    append(" y soy un ")
                                    
                                    withStyle(
                                        style = SpanStyle(
                                            color = Color.Blue
                                        )
                                    ) { append("CRACK") }
                                },
                            fontSize = 22.sp
                            )
                        """.trimIndent()
                    )

                }

            }
        }
    }
}