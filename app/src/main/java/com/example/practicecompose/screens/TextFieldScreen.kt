package com.example.practicecompose.screens

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
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.practicecompose.CodeBlock

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldScreen(navController: NavHostController) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Text Field") },
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
                    var text by remember { mutableStateOf("") }
                    var text2 by remember { mutableStateOf("") }
                    var showPassword by remember { mutableStateOf(false) }
                    TextField(
                        value = text,
                        onValueChange = { text = it },
                        label = { Text("username") },
                        maxLines = 3,
                        modifier = Modifier.fillMaxWidth()
                    )
                    OutlinedTextField(
                        value = text2,
                        onValueChange = { text2 = it },
                        label = { Text("password") },
                        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                        trailingIcon = {
                            IconButton(onClick = { showPassword = !showPassword }) {
                                if(showPassword) {
                                    Icon(
                                        imageVector = Icons.Default.Visibility,
                                        contentDescription = "don't show password"
                                    )
                                } else {
                                    Icon(
                                        imageVector = Icons.Default.VisibilityOff,
                                        contentDescription = "show password"
                                    )
                                }
                            }
                        },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Column {
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            "Ejemplo de código:",
                            fontWeight = FontWeight.Bold,
                        )
                        CodeBlock(
                            code = """
                            TextField(
                                value = textValue,
                                onValueChange = { textValue = it },
                                label = {},
                                singleLine = boolean,
                                maxLine = Int,
                                trailingIcon = IconButton(),
                                visualTransformation = 
                                    PasswordVisualTransformation(),
                                    VisualTransformation.None,
                            )
                        """.trimIndent()
                        )

                    }

                }
            }
        }
    }
}