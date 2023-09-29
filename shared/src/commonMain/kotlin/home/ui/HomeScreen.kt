package home.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import home.viewmodel.HomeViewModel
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import kotlinx.coroutines.internal.LockFreeLinkedListNode

@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {

    LaunchedEffect(Unit){
        homeViewModel.getImages()
    }
    val birdDataList by homeViewModel.birdItemStateFlow.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(vertical = 70.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Row(modifier = Modifier.fillMaxWidth().padding(5.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(5.dp)

        ) {
            birdDataList.images.forEach {
                Button(onClick = {
                    homeViewModel.setCategory(it)
                },
                    modifier = Modifier.wrapContentSize().padding(5.dp),
                    shape = ButtonDefaults.elevatedShape,
                    colors = ButtonDefaults.buttonColors(),){

                    Text(it.toString())
                }
            }

        }


        LazyVerticalGrid(
            modifier = Modifier.fillMaxSize().padding(horizontal = 5.dp),
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            content = {
                val imageList = birdDataList.imageList
                items(imageList.size) { index ->
                    KamelImage(
                        resource = asyncPainterResource(data = "https://sebi.io/demo-image-api/".plus(imageList[index].path)),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth().aspectRatio(1f)
                    )
                }
            }
        )
    }
}


