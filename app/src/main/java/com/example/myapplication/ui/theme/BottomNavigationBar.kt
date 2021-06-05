package com.example.myapplication.ui.theme

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomBar(){
    BottomNavigation(

    ){

    }
}

@Composable
fun BottomBar(navController: NavController){

    val items = listOf(
        Screen.Home,
        Screen.Search,
        Screen.Favourites,
        Screen.Profile,
    )

    BottomNavigation(
        elevation = 5.dp
    ){
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.map {
            BottomNavigationItem(
                icon= {
                    Icon(
                        painter = painterResource(id = it.icon),
                        contentDescription = it.title
                    )
                },
                label= {
                       Text(
                           text = it.title
                       )
                },
                selected = currentRoute == it.route,
                selectedContentColor= Color.White,
                unselectedContentColor= Color.White.copy(alpha = 0.4f),
                onClick = {
                    navController.navigate(it.route){
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        restoreState = true
                        launchSingleTop = true
                    }
                }
            )
        }

    }
}