package com.example.practicecompose.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.practicecompose.CodeBlock

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RadiosScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Radios") },
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

            Column(modifier = Modifier.padding(16.dp).verticalScroll(rememberScrollState())) {
                var radioValue1 by remember { mutableStateOf(false) }
                RadioButton(
                    selected = radioValue1,
                    onClick = { radioValue1 = !radioValue1 }
                )

                HorizontalDivider()

                var radioValue2 by remember { mutableStateOf(false) }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = radioValue2,
                        onClick = { radioValue2 = !radioValue2 }
                    )
                    Text("Radio button")
                }

                HorizontalDivider()

                var radioValue by remember { mutableIntStateOf(1) }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (radioValue == 1),
                        onClick = { radioValue = 1 }
                    )
                    Text("Opcion 1")
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (radioValue == 2),
                        onClick = { radioValue = 2 }
                    )
                    Text("Opcion 2")
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (radioValue == 3),
                        onClick = { radioValue = 3 }
                    )
                    Text("Opcion 3")
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = (radioValue == 4),
                        onClick = { radioValue = 4 }
                    )
                    Text("Opcion 4")
                }
                Text(
                    text = "(radioValue == $radioValue ) ",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(16.dp)
                )

                HorizontalDivider()

                var radioValuesColor by remember { mutableStateOf(false) }
                RadioButton(
                    selected = radioValuesColor,
                    enabled = true,
                    onClick = { radioValuesColor = !radioValuesColor },
                    colors = RadioButtonDefaults.colors(
                        selectedColor = Color.Red,
                        unselectedColor = Color.Blue,
                        disabledSelectedColor = Color.Blue,
                        disabledUnselectedColor = Color.Red
                    )
                )

                Column {
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "Ejemplo de código:",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(16.dp, 0.dp)
                    )
                        CodeBlock(
                            code = """
                        RadioButton(
                            selected = (radioValue == 1),
                            onClick = { radioValue = 1 }
                        )
                        selected = Siempre es un tipo boolean
                        """.trimIndent()
                        )
                    Text(
                        "Cambio de color:",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(16.dp, 0.dp)
                    )
                    CodeBlock(
                        code = """
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color.Red,
                            unselectedColor = Color.Blue,
                            disabledSelectedColor = Color.Blue,
                            disabledUnselectedColor = Color.Red
                        )
                        """.trimIndent()
                    )
                }
            }

        }
    }
}