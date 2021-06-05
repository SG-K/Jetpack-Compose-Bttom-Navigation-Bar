package com.example.myapplication.ui.theme

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.BottomBarMain

@Composable
fun MainView(){
    val navController = rememberNavController()
    Scaffold (
            bottomBar = {
            BottomBar(
                navController
            )
        }
    )
    {
        BottomBarMain(navController)
    }

}