package com.example.practicecompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.practicecompose.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PracticeScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Practice") },
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
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            LinearProgressIndicator(
                modifier = Modifier.fillMaxWidth()
            )
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize(),
            ) {

                var switchChecked by remember { mutableStateOf(false) }
                Switch(
                    checked = switchChecked,
                    onCheckedChange = { switchChecked = it }
                )
                Checkbox(
                    checked = switchChecked,
                    onCheckedChange = { switchChecked = it }
                )

                var optionsValue by remember { mutableIntStateOf(1) }
                var isEnabled by remember { mutableStateOf(false) }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable {
                        if (isEnabled) {
                            optionsValue = 1
                        }
                    }
                ) {
                    RadioButton(
                        selected = (optionsValue == 1),
                        onClick = { optionsValue = 1 },
                        enabled = isEnabled
                    )
                    Text("Opcion 1")
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable { optionsValue = 2 }
                ) {
                    RadioButton(
                        selected = (optionsValue == 2),
                        onClick = { optionsValue = 2 }
                    )
                    Text("Opcion 2")
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable { optionsValue = 3 }
                ) {
                    RadioButton(
                        selected = (optionsValue == 3),
                        onClick = { optionsValue = 3 }
                    )
                    Text("Opcion 3")
                }

                var notifyValue by remember { mutableIntStateOf(0) }
                BadgedBox(
                    badge = {
                        Badge() { Text("$notifyValue") }
                    }
                ) {
                    IconButton(onClick = { notifyValue++ }, modifier = Modifier.size(40.dp)) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "",
                            modifier = Modifier.scale(1.5f)
                        )
                    }
                }

                LinearProgressIndicator(Modifier.fillMaxWidth())
                CircularProgressIndicator(Modifier.padding(vertical = 16.dp))
                Image(
                    painter = painterResource(id = R.drawable.jesus),
                    contentDescription = "Jesus"
                )
//                AsyncImage(model = "https://pbs.twimg.com/media/Gvq7Md5XMAA0hT6?format=jpg&name=medium", contentDescription = "internet")
                var sliderValue by remember { mutableFloatStateOf(0f) }
                Slider(
                    value = sliderValue,
                    onValueChange = { sliderValue = it },
                    valueRange = 0f..5f,
                    steps = 4,
                    enabled = false,
                    modifier = Modifier.padding(16.dp),
                    colors = SliderDefaults.colors(
                        activeTrackColor = Color.Red,
                        thumbColor = Color.Black
                    )
                )
                Text("$sliderValue")

            }

        }
    }
}