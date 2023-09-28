package home.repository

import home.data.ImageItem
import io.ktor.client.call.*
import io.ktor.client.request.*
import networkmodule.KtorModule

/**
 * Created by Anurag on 26/09/23 10:04 pm
 **/
class DefaultImageRepository(): ImageRepository {

    override suspend fun getImages(): List<ImageItem> {
        val request = KtorModule.getHttpClient.get(" https://sebi.io/demo-image-api/pictures.json")
        println("Anurag Request Url = ${request.toString()}")
        return request.body<List<ImageItem>>()
    }
}