package settings

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun SettingScreen(textUpdateState: MutableState<String>) {
    Text(
        text = textUpdateState.value,
        fontSize = 30.sp,
        color = Color.Gray
    )
}