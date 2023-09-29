import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import bottomnavbar.navigationItemList

@Composable
fun CustomBottomAppBar(textUpdateState: MutableState<String>) {
    BottomAppBar(
        modifier = Modifier.fillMaxWidth(),
        containerColor = Color.LightGray,
        contentColor = Color.Blue,
        tonalElevation = 5.dp,
        contentPadding = PaddingValues(10.dp),
        content = {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically){
                navigationItemList.forEach {
                    Column(verticalArrangement = Arrangement.SpaceBetween,
                        horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(imageVector = it.icon, "")
                        Text(it.name, modifier = Modifier.clickable(
                            onClick = {
                                textUpdateState.value = it.name
                            }
                        ))
                    }
                }
            }
        }
    )
}