package com.medicare.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import kotlinx.coroutines.time.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF141414)),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
    ) {
        Image(painter = painterResource(R.drawable.spash),
            contentDescription = "Splash Icon",
            modifier = Modifier.background(Color.Transparent))

        Text(text = "DeadPancake Nums",
            fontWeight = FontWeight.W600,
            fontSize = 48.sp,
            softWrap = true,
            fontFamily = FontFamily.Cursive,
            color = Color.White
        )
    }

    LaunchedEffect(Unit) {
        kotlinx.coroutines.delay(2000)
        navController.navigate("home") {
            popUpTo("splash") { inclusive = true }
        }
    }
}