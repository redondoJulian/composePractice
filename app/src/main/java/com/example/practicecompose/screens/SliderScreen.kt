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
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
fun SliderScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Slider") },
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

                    CodeBlock("""
                        Slider(
                            value = ,
                            onChangeValue = {},
                            steps = ,
                            valueRange = 0f .. 10f,
                            colors = SliderDefaults.colors(
                                thumbColor = ,
                                activeTrackColor = ,
                            )
                        )
                    """.trimIndent())

                    var sliderValue by remember {
                        mutableFloatStateOf(0.0f)
                    }
                    var stepsValue by remember{
                        mutableIntStateOf(0)
                    }
                    var stepsRange by remember{
                        mutableFloatStateOf(5f)
                    }
                    var stepsValueField by remember { mutableStateOf("") }
                    var stepsRangeField by remember { mutableStateOf("") }
                    Slider(
                        modifier = Modifier.padding(16.dp),
                        value = sliderValue,
                        onValueChange = {sliderValue = it},
                        steps = stepsValue,
                        valueRange = 1f..stepsRange,
                        colors = SliderDefaults.colors(
                            activeTrackColor = Color.Black,
                            thumbColor = Color.Black
                        )
                    )
                    var sliderValue2 = sliderValue.toInt()
                    Text("$sliderValue2")
                    Text("$sliderValue")
                    HorizontalDivider()
                    OutlinedTextField(
                        value = stepsValueField,
                        onValueChange = {stepsValueField = it},
                        label = {Text("Steps")}
                    )
                    OutlinedTextField(
                        value = stepsRangeField,
                        onValueChange = {stepsRangeField = it},
                        label = {Text("Range")}
                    )
                    Button(onClick = {
                        stepsValue = stepsValueField.toInt()
                        stepsRange = stepsRangeField.toFloat()
                    }
                    ) { Text("Actualizar") }

                }

            }
        }
    }
}