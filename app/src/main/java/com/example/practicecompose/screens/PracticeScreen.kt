package com.example.practicecompose.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.NotificationsOff
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.practicecompose.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PracticeScreen(navController: NavHostController) {

    var pagerState = rememberPagerState(pageCount = { 5 })
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val listColors = listOf(Color.Yellow, Color.Red, Color.Blue, Color.Green, Color.White)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                drawerShape = RectangleShape
            ) {
                Box(Modifier.padding(16.dp)) {
                    TextButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Text("Volver")
                    }
                }
            }
        }
    ) {

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Clean") },
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    drawerState.apply {
                                        if (isClosed) open() else close()
                                    }
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "go back"
                            )
                        }
                    },
                    actions = {
                        var dropMenu by remember { mutableStateOf(false) }
                        IconButton(onClick = { dropMenu = true }) {
                            Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
                        }
                        DropdownMenu(
                            expanded = dropMenu,
                            onDismissRequest = { dropMenu = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text("Volver") },
                                onClick = {
                                    navController.popBackStack()
                                    dropMenu = false
                                },
                                leadingIcon = {
                                    Icon(
                                        imageVector = Icons.Default.ExitToApp,
                                        contentDescription = null
                                    )
                                }
                            )
                        }
                    }
                )
            },
            bottomBar = {
                BottomAppBar {
                    Row(
                        horizontalArrangement = Arrangement.Absolute.SpaceAround,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        IconButton(onClick = {

                        }) { Icon(imageVector = Icons.Default.Lock, contentDescription = null) }
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = null
                            )
                        }
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = null
                            )
                        }
                        IconButton(onClick = {}) {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = null
                            )
                        }
                    }
                }
            },
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        navController.popBackStack()
                    },
                    contentColor = Color.Black,
                    containerColor = Color.White,
                    shape = CircleShape
                ) {
                    CircularProgressIndicator()
                    Icon(imageVector = Icons.Default.Star, contentDescription = null)
                }
            },
        ) { paddingValues ->

            Box(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {

                Column() {
                    LinearProgressIndicator(
                        modifier = Modifier.fillMaxWidth(),
                    )
                    HorizontalPager(
                        state = pagerState,
                        modifier = Modifier.height(200.dp)
                    ) {
                        Box(
                            Modifier
                                .fillMaxSize()
                                .background(listColors[it]),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(it.toString())
                            Image(
                                painter = painterResource(id = R.drawable.ic_launcher_background),
                                contentDescription = null,
                                modifier = Modifier.clip(CircleShape)
                            )
                        }
                    }

                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                            .fillMaxSize()
                    ) {
                        var optionsComp by remember { mutableStateOf(false) }
                        Switch(
                            checked = optionsComp,
                            onCheckedChange = {optionsComp = it}
                        )
                        RadioButton(
                            selected = optionsComp,
                            onClick = {optionsComp = !optionsComp}
                        )
                        Checkbox(
                            checked = optionsComp,
                            onCheckedChange = {optionsComp = it}
                        )
                        Card(

                            modifier = Modifier.padding(16.dp),
                            elevation = CardDefaults.elevatedCardElevation(
                                defaultElevation = 15.dp
                            )
                        ) {
                            Text(
                                text = "Cards",
                                modifier = Modifier
                                    .padding(16.dp)
                                    .size(width = 200.dp, height = 300.dp),
                                textAlign = TextAlign.Center
                            )
                        }

                        var sliderValue by remember { mutableFloatStateOf(0f) }
                        Slider(
                            value = sliderValue,
                            onValueChange = { sliderValue = it },
                            valueRange = 0f..10f,
                            steps = 1,
                            modifier = Modifier.padding(horizontal = 32.dp)
                        )

                        var badgeCount by remember { mutableIntStateOf(0) }
                        BadgedBox(
                            badge = {
                                Badge() {
                                    Text("$badgeCount")
                                }
                            },
                            modifier = Modifier.padding(16.dp)
                        ) {
                            IconButton(onClick = { badgeCount++ }) {
                                Icon(
                                    imageVector = Icons.Default.Notifications,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .padding(8.dp)
                                        .scale(1.4f)
                                )
                            }
                        }

                        var textValue by remember { mutableStateOf("") }
                        var showPassword by remember { mutableStateOf(false) }
                        OutlinedTextField(
                            value = textValue,
                            onValueChange = { textValue = it },
                            label = { Text("Prueba") },
                            modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                            visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Notifications,
                                    contentDescription = null,
                                )
                            },
                            trailingIcon = {
                                IconButton(onClick = { showPassword = !showPassword }) {
                                    if (showPassword) {
                                        Icon(
                                            imageVector = Icons.Default.Notifications,
                                            contentDescription = null,
                                        )
                                    } else {
                                        Icon(
                                            imageVector = Icons.Default.NotificationsOff,
                                            contentDescription = null,
                                        )
                                    }
                                }
                            },
                        )

                        Spacer(
                            Modifier.height(80.dp)
                        )

                    }
                }


            }
        }

    }

}
