package net.simplifiedcoding.ui.home

import android.annotation.SuppressLint
import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.simplifiedcoding.data.utils.gridViewItems
import net.simplifiedcoding.navigation.ROUTE_HOME
import net.simplifiedcoding.navigation.ROUTE_PROFILE
import net.simplifiedcoding.ui.auth.AuthViewModel
import net.simplifiedcoding.ui.theme.AppTheme


data class BasicGridViewModel(
    val route: String,
    val name: String,
    val image: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(viewModel: AuthViewModel?, navController: NavHostController) {

        Scaffold(
            topBar = {
                TopAppBar(
                    modifier = Modifier,
                    title = {
                        Row {

                            Spacer(modifier = Modifier
                                .width(5.dp))
                            Text(text = "KALICAPTURE", color = Color.Magenta)
                        }

                    },
                    actions = {
                        IconButton(onClick = { navController.navigate(ROUTE_PROFILE){
                            popUpTo(ROUTE_HOME) {inclusive = true}
                        } }

                                ) {
                            Icon(Icons.Default.AccountBox, "profile")

                        }
                    }

                )

            }

        ) {



                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    verticalArrangement = Arrangement.spacedBy(2.dp),
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                    modifier = Modifier
                        .background(Color.Black)
                ) {


                    items(gridViewItems.size) {

                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .clickable {
                                    navController.navigate(gridViewItems[it].route)
                                }
                        ) {
                            Image(
                                painter = painterResource(id = gridViewItems[it].image),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,

                                modifier = Modifier
                                    .fillMaxSize()
                                    .height(180.dp)
                            )
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(30.dp)
                                    .align(Alignment.BottomCenter)
                                    .background(Color.Black.copy(alpha = 0.3f))
                                    .padding(horizontal = 5.dp),
                                Arrangement.Center,
                                Alignment.CenterVertically
                            ) {

                                Box (
                                    modifier = Modifier.
                                            clickable {
                                                navController.navigate(gridViewItems[it].route)
                                            }
                                        ){
                                    Text(
                                        modifier = Modifier,
                                        text = gridViewItems[it].name,
                                        style = TextStyle(
                                            color = Color.White
                                        ),

                                    )
                                }



                            }

                        }


            }}

}
}


@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun HomeScreenPreviewLight() {
    AppTheme {
        HomeScreen(null, rememberNavController())
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeScreenPreviewDark() {
    AppTheme {
        HomeScreen(null, rememberNavController())
    }
}


