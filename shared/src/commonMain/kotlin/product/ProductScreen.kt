package product

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.kamel.image.KamelImage
import io.kamel.image.asyncPainterResource
import org.jetbrains.compose.resources.ExperimentalResourceApi
import product.viewmodel.ProductViewModel

@OptIn(ExperimentalResourceApi::class)
@Composable
fun ProfileScreen(profileViewModel: ProductViewModel) {

    LaunchedEffect(Unit){
        profileViewModel.getProfileData()
    }
    val profileData by profileViewModel.profileStateFlow.collectAsState()
    Column(
        modifier = Modifier.fillMaxSize().padding(vertical = 60.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        LazyRow(
            modifier = Modifier.fillMaxWidth().padding(5.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(5.dp)

        ) {
            profileData.categorySet?.let {
                it?.size?.let { it1 ->
                    items(it1) {
                        Button(
                            onClick = {
                                profileViewModel.setProductCategory(profileData.categorySet!!.elementAt(it))
                            },
                            modifier = Modifier.wrapContentSize(),
                            shape = ButtonDefaults.elevatedShape,
                            colors = ButtonDefaults.buttonColors(),
                        ) {

                            Text(profileData.categorySet!!.elementAt(it).toString())
                        }
                    }
                }
            }

        }
        LazyColumn(
            modifier = Modifier.fillMaxSize().padding(vertical = 5.dp),
            verticalArrangement = Arrangement.spacedBy(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (profileData.productList.isNullOrEmpty().not()) {
                items(profileData.productList!!.size) { index ->
                    val productList = profileData.productList
                    Card(
                        modifier = Modifier.fillMaxSize(),
                        shape = CardDefaults.elevatedShape,
                        colors = CardDefaults.cardColors(containerColor = Color.DarkGray),
                        elevation = CardDefaults.cardElevation(5.dp)
                    ) {
                        val products = productList!![index]
                        Row(
                            modifier = Modifier.wrapContentSize().padding(10.dp),
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.Top
                        ) {

                            KamelImage(
                                resource = asyncPainterResource(data = products.thumbnail),
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier.size(100.dp).clip(CircleShape),
                                onLoading = {

                                }
                            )
                            Column(
                                modifier = Modifier.wrapContentSize().padding(10.dp),
                                verticalArrangement = Arrangement.Top,
                                horizontalAlignment = Alignment.Start,
                            ) {
                                Text(
                                    text = products.title,
                                    color = Color.White,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.wrapContentSize().padding(5.dp),
                                )
                                Text(
                                    text = products.brand,
                                    color = Color.White,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Medium,
                                    modifier = Modifier.wrapContentSize().padding(5.dp),
                                )
                                Text(
                                    text = products.category,
                                    color = Color.White,
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Medium,
                                    modifier = Modifier.wrapContentSize().padding(5.dp),
                                )
                            }

                        }

                    }
                }
            }
        }
    }
}