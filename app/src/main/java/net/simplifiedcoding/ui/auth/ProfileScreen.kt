package net.simplifiedcoding.ui.home

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.simplifiedcoding.R
import net.simplifiedcoding.navigation.ROUTE_HOME
import net.simplifiedcoding.navigation.ROUTE_LOGIN
import net.simplifiedcoding.ui.auth.AuthViewModel
import net.simplifiedcoding.ui.theme.AppTheme
import net.simplifiedcoding.ui.theme.spacing

@Composable
fun ProfileScreen(viewModel: AuthViewModel?, navController: NavHostController) {
    val spacing = MaterialTheme.spacing
    Box(modifier = Modifier){
        Image(painter = painterResource(id = R.drawable.oop), contentDescription = null, modifier = Modifier
            .fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .fillMaxHeight()
                .padding(spacing.medium)
                .padding(top = spacing.extraLarge),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = stringResource(id = R.string.Profile),
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Green
            )

            Text(
                text = viewModel?.currentUser?.displayName ?: "",
                style = MaterialTheme.typography.displaySmall,
                color = Color.Green
            )

            Image(
                painter = painterResource(id = R.drawable.ic_person),
                contentDescription = stringResource(id = R.string.empty),
                modifier = Modifier.size(128.dp)

            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(spacing.medium)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(id = R.string.name),
                        style = TextStyle(color = Color.Green, textAlign = TextAlign.Center, fontSize = 12.sp),
                        modifier = Modifier
                            .weight(0.7f)
                            .fillMaxWidth(),


                    )

                    Spacer(modifier = Modifier.width(5.dp))

                    Text(
                        text = viewModel?.currentUser?.displayName ?: "",
                        style = TextStyle(color = Color.Green, textAlign = TextAlign.Center, fontSize = 12.sp),
                        modifier = Modifier
                            .weight(0.7f)
                            .fillMaxWidth(),
                        color = Color.Green,
                    )
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Text(
                        text = stringResource(id = R.string.email),
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .weight(0.3f)
                            .fillMaxWidth(),
                        color = Color.Green,
                        textAlign = TextAlign.Center,
                    )

                    Text(
                        text = viewModel?.currentUser?.email ?: "",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .weight(0.7f)
                            .fillMaxWidth(),
                        color = Color.Green,
                        textAlign = TextAlign.Center
                    )
                }

                Button(
                    onClick = {
                        viewModel?.logout()
                        navController.navigate(ROUTE_LOGIN) {
                            popUpTo(ROUTE_HOME) { inclusive = true }
                        }
                    },
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .padding(top = spacing.extraLarge)
                ) {
                    Text(text = stringResource(id = R.string.logout))
                }
            }
        }
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
@Composable
fun ProfileScreenPreviewLight() {
    AppTheme {
        ProfileScreen(null, rememberNavController())
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun ProfileScreenPreviewDark() {
    AppTheme {
        ProfileScreen(null, rememberNavController())
    }
}
