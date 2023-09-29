import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import bottomnavbar.navigationItemList
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import home.viewmodel.HomeViewModel
import org.jetbrains.compose.resources.ExperimentalResourceApi
import product.viewmodel.ProductViewModel

@OptIn(ExperimentalResourceApi::class, ExperimentalMaterial3Api::class)
@Composable
fun App() {
    val textUpdateState = remember {
        mutableStateOf(navigationItemList[0].name)
    }
    val homeViewModel  = getViewModel(key = Unit, viewModelFactory { HomeViewModel() })
    val profileViewModel: ProductViewModel = getViewModel(Unit, viewModelFactory { ProductViewModel() })
    MaterialTheme {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.White),
            containerColor = Color.White,
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = textUpdateState.value, color = Color.White)
                    },
                    navigationIcon = {
                        /*IconButton(onClick = {}) {
                            Icon(Icons.Filled.ArrowBack, "backIcon")
                        }*/
                    },
                    actions ={
                        IconButton(onClick = {}) {
                            Icon(Icons.Filled.Search, "search Icon")
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Blue,)
                )
            },
            bottomBar = {
                CustomBottomAppBar(textUpdateState)
            },
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ScreenNavigator(textUpdateState, homeViewModel, profileViewModel)
                }
            }
        )

    }
}



expect fun getPlatformName(): String