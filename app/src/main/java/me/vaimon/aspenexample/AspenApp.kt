package me.vaimon.aspenexample

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.HiltAndroidApp
import me.vaimon.aspenexample.navigation.AspenNavHost

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AspenApp(navController: NavHostController = rememberNavController()) {
    AspenNavHost(navController = navController)
}

@HiltAndroidApp
class AspenApplication : Application()