package bottomnavbar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

/**
 * Created by Anurag on 27/09/23 10:05 pm
 **/
data class NavItem(
    val name: String,
    val route: String,
    val icon: ImageVector
)

val navigationItemList: List<NavItem> = mutableListOf(

    NavItem(name = "Product", route = "product", icon = Icons.Default.Person),
    NavItem(name = "Home", route = "home", icon = Icons.Default.Home),
    NavItem(name = "Settings", route = "settings", icon = Icons.Default.Settings)
)

enum class Screens{
    Product, Home,  Settings
}