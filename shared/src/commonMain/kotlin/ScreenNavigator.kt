import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import bottomnavbar.Screens
import home.ui.HomeScreen
import home.viewmodel.HomeViewModel
import product.ProfileScreen
import product.viewmodel.ProductViewModel
import settings.SettingScreen

@Composable
fun ScreenNavigator(
    textUpdateState: MutableState<String>,
    homeViewModel: HomeViewModel,
    profileViewModel: ProductViewModel
) {
    when(textUpdateState.value){
        Screens.Product.name -> {
            ProfileScreen(profileViewModel)
        }

        Screens.Home.name -> {
            HomeScreen(homeViewModel)
        }

        Screens.Settings.name -> {
           SettingScreen(textUpdateState)
        }
    }
}