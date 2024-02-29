package me.vaimon.aspenexample.ui.screens.welcome

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import me.vaimon.aspenexample.R
import me.vaimon.aspenexample.navigation.NavigationDestination
import me.vaimon.aspenexample.ui.common.ActionButton
import me.vaimon.aspenexample.ui.common.CompositeHeader
import me.vaimon.aspenexample.ui.theme.AspenExampleTheme
import me.vaimon.aspenexample.util.PreviewMediumScreen

object WelcomeDestination : NavigationDestination {
    override val route = "welcome"
}

@Composable
fun WelcomeScreen(
    viewModel: WelcomeViewModel,
    navigateToHome: () -> Unit
) {
    WelcomeBody(onBtnExploreClick = navigateToHome)
}

@Composable
private fun WelcomeBody(
    onBtnExploreClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier
        .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.welcome_background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            Modifier
                .padding(horizontal = 32.dp, vertical = 48.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Spacer(modifier = Modifier.height(48.dp))
            Text(
                text = "Aspen",
                style = MaterialTheme.typography.displayLarge,
                color = Color.White
            )

            Spacer(modifier = Modifier.weight(1f))
            CompositeHeader(
                headerText = stringResource(R.string.title_body),
                secondaryHeaderText = stringResource(R.string.title_header),
                textColor = Color.White,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))
            ActionButton(
                buttonText = stringResource(R.string.btn_explore),
                onClick = onBtnExploreClick,
                modifier = Modifier.fillMaxWidth()
            )
        }

    }
}

@PreviewMediumScreen
@Composable
fun PreviewWelcome() {
    AspenExampleTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            WelcomeBody(onBtnExploreClick = {

            })
        }
    }
}