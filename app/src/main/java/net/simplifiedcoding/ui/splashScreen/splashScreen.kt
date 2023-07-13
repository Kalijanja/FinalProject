package net.simplifiedcoding.ui.splashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.delay
import net.simplifiedcoding.R
import net.simplifiedcoding.navigation.ROUTE_LOGIN
import net.simplifiedcoding.navigation.ROUTE_SPLASH


@Composable
fun splashScreen(navController: NavController){

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.splash))
    var isPlaying by remember { mutableStateOf(false) }
    val progress by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = isPlaying,
        iterations = LottieConstants.IterateForever,
        restartOnPlay = false
    )



    LaunchedEffect(key1 = true){
//        if (progress == 0f) isPlaying = true
//        if (progress == 1f) isPlaying = false
        delay(1000)
        navController.navigate(ROUTE_LOGIN){
            popUpTo(ROUTE_SPLASH) {inclusive = true}
        }
    }
    Column(modifier = Modifier
            .fillMaxSize()
        .background(Color.Black),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//        animation(height = 200)


        Image(painter = painterResource(id = R.drawable.logo), contentDescription = "",
        modifier = Modifier
            .width(200.dp)
            .height(200.dp))

    }

}

//    navController: NavHostController,
//    time: Long
//): Unit {
//    Box(modifier = Modifier.fillMaxSize()){
//        Text(
//            text = "SplashScreen",
//            textAlign = TextAlign.Center,
//            fontSize = 90.sp,
//            color = Color(0xFFFFFFFF)
//        )
//    }
//    val handler = android.os.Handler()
//    handler.postDelayed({
//        navController.navigate(
//            ROUTE_LOGIN
//        )},
//        time
//    )
//}


