package com.example.practicecompose.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.practicecompose.CodeBlock

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropwdownScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Dropdown") },
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

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {

                CodeBlock(
                    """
                    DropdownMenu(
                        modifier = Modifier.fillMaxWidth(fraction = 0.91f),
                        expanded = true,
                        onDismissRequest = {}
                    ){
                        DropdownMenuItem(
                            text = {}
                            onClick = {}
                        )
                    }
                """.trimIndent()
                )

                CodeBlock(
                    """
                    ExposedDropdownMenuBox(
                        expanded = true,
                        onExpandedChange = {
                            expanded = !expanded
                        }
                    ) {
                        TextField(
                             readOnly = true,
                             trailingIcon = {
                                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                             },
                        )
                        
                        ExposedDropdownMenu(
                            expanded = true,
                            onDismissRequest = {}
                        ){
                            DropdownMenuItem(
                                text = {}
                                onClick = {}
                            )
                        }
                    }
                """.trimIndent()
                )


                var textfieldValue by remember { mutableStateOf("") }
                var dropdownExpanded by remember { mutableStateOf(false) }

                ExposedDropdownMenuBox(
                    expanded = dropdownExpanded,
                    onExpandedChange = {
                        dropdownExpanded = !dropdownExpanded
                    }
                ) {
                    TextField(
                        value = textfieldValue,
                        onValueChange = {},
                        readOnly = true, // Es importante para que funcione bien como dropdown
                        label = { Text("Introducir serie") },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = dropdownExpanded)
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .menuAnchor() // Ancla el menú al TextField
                    )

                    ExposedDropdownMenu(
                        expanded = dropdownExpanded,
                        onDismissRequest = { dropdownExpanded = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text("Serie 1") },
                            onClick = {
                                textfieldValue = "Serie 1"
                                dropdownExpanded = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Serie 2") },
                            onClick = {
                                textfieldValue = "Serie 2"
                                dropdownExpanded = false
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Serie 3") },
                            onClick = {
                                textfieldValue = "Serie 3"
                                dropdownExpanded = false
                            }
                        )
                    }
                }

            }
        }
    }
}