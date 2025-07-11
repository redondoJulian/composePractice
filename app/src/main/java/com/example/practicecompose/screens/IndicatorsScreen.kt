package com.example.practicecompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.practicecompose.CodeBlock
import com.example.practicecompose.R
import com.example.practicecompose.SealedClassNavigation.remember

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun IndicatorsScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Indicators") },
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
                                            LinearProgressIndicator(
                                                color = Color.Black,
                                                trackColor = Color.LightGray,
                                                progress = { }
                                            )
                    """.trimIndent())
                    CodeBlock("""
                                            CircularProgressIndicator(
                                                color = Color.Black,
                                                trackColor = Color.LightGray,
                                                progress = { 0f }
                                            )
                    """.trimIndent())

                    Text(text = "Circular Indicator", modifier = Modifier.padding(16.dp))
                    CircularProgressIndicator(
                        modifier = Modifier.padding(16.dp),
                        color = Color.Black,
                        trackColor = Color.LightGray,
                        strokeWidth = 8.dp
                    )

                    Text(text = "Circular Indicator control", modifier = Modifier.padding(16.dp))
                    var circularValue by remember {
                        mutableStateOf(0.0f)
                    }
                    CircularProgressIndicator(
                        modifier = Modifier.padding(16.dp),
                        color = Color.Black,
                        trackColor = Color.LightGray,
                        strokeWidth = 8.dp,
                        progress = { circularValue }
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        ElevatedButton(onClick = { circularValue-=0.05f }) { Text("Disminuir") }
                        ElevatedButton(onClick = { circularValue+=0.05f }) { Text("Aumentar") }
                    }

                    HorizontalDivider()

                    Text(text = "Progress bar Indicator", modifier = Modifier.padding(16.dp))
                    LinearProgressIndicator(
                        modifier = Modifier.fillMaxWidth().padding(16.dp),
                        color = Color.Black,
                        trackColor = Color.LightGray,
                    )

                    var linearValue by remember {
                        mutableStateOf(0.0f)
                    }
                    Text(text = "Progress bar Indicator control", modifier = Modifier.padding(16.dp))
                    LinearProgressIndicator(
                        modifier = Modifier.fillMaxWidth().padding(16.dp),
                        color = Color.Black,
                        trackColor = Color.LightGray,
                        progress = { linearValue }
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        ElevatedButton(onClick = { linearValue-=0.05f }) { Text("Disminuir") }
                        ElevatedButton(onClick = { linearValue+=0.05f }) { Text("Aumentar") }
                    }
                }


            }
        }
    }
}