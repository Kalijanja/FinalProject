package net.simplifiedcoding.data.utils

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.simplifiedcoding.R
import net.simplifiedcoding.ui.auth.AuthViewModel
import net.simplifiedcoding.ui.theme.AppTheme

@Composable
fun ButterflyScreen(viewModel: AuthViewModel?, navController: NavHostController){
    Box(modifier = Modifier
        .fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.butterfly),
            contentDescription = null,
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize())
    }
}



@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun ButterflyScreenPreviewLight() {
    AppTheme {
        ButterflyScreen(null, rememberNavController())
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ButterflyScreenPreviewDark() {
    AppTheme {
        ButterflyScreen(null, rememberNavController())
    }
}
