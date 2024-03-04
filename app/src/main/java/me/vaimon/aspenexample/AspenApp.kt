package me.vaimon.aspenexample

import android.annotation.SuppressLint
import android.app.Application
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.HiltAndroidApp
import me.vaimon.aspenexample.ui.navigation.AspenNavHost

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AspenApp() {
    AspenNavHost()
}

@HiltAndroidApp
class AspenApplication : Application()