package com.example.practicecompose.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FmdGood
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MonetizationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Wallet
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Cloud
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.practicecompose.CodeBlock
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModalNavigatorDrawerScreen(navController: NavHostController) {
    var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Column() {
                    Row(
                        horizontalArrangement = Arrangement.SpaceAround,
                        verticalAlignment = Alignment.Top,
                        modifier = Modifier.padding(16.dp),
                    ) {
                        Box(Modifier.width(230.dp)) {
                            Text(
                                text = "Kikita hermoña uwu",
                                fontSize = 32.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(top = 8.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.FmdGood,
                                contentDescription = "go back"
                            )
                            Text(text = "1", fontWeight = FontWeight.Bold)
                        }
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.AccountCircle,
                            contentDescription = "go back"
                        )
                        Text(text = "My profile", Modifier.padding(start = 8.dp))
                    }

                    HorizontalDivider(
                        Modifier.width(300.dp)
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Cloud,
                            contentDescription = "go back"
                        )
                        Text(text = "Horarios disponibles", Modifier.padding(start = 8.dp))
                    }

                    HorizontalDivider(
                        Modifier.width(300.dp)
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Notifications,
                            contentDescription = "go back"
                        )
                        Text(text = "Notificaciones", Modifier.padding(start = 8.dp))
                    }

                    HorizontalDivider(
                        Modifier.width(300.dp)
                    )

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.Wallet,
                            contentDescription = "go back"
                        )
                        Text(text = "Cartera", Modifier.padding(start = 8.dp))
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.MonetizationOn,
                            contentDescription = "go back"
                        )
                        Text(text = "Pagos", Modifier.padding(start = 8.dp))
                    }

                    HorizontalDivider(
                        Modifier.width(300.dp)
                    )

                    TextButton(
                        onClick = { navController.popBackStack()},
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(
                            text = "Logout",
                            color = Color.Red,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                    }
                }
            }
        }
    ) {

        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("ModalNavigatorDrawer") },
                    navigationIcon = {
                        IconButton(onClick = {
                            scope.launch {
                                drawerState.apply {
                                    if (isClosed) open() else close()
                                }
                            }
                        }) {
                            Icon(
                                imageVector = Icons.Default.Menu,
                                contentDescription = "go back"
                            )
                        }
                    }
                )
            }
        ) { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {

                Column(

                ) {

                    CodeBlock("""
                            var drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
                            val scope = rememberCoroutineScope()
                            
                            ModalNavigationDrawer(
                                drawerState = drawerState,
                                drawerContent = {
                                    ModalDrawerSheet {
                                    }
                                }
                            ){
                            
                                Scaffold(){}
                            
                            }
                    """.trimIndent())

                }
            }
        }

    }
}