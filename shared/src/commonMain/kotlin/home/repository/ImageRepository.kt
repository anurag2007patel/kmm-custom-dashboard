package home.repository

import home.data.ImageItem

/**
 * Created by Anurag on 26/09/23 10:04 pm
 **/
interface ImageRepository {

    suspend fun getImages(): List<ImageItem>
}