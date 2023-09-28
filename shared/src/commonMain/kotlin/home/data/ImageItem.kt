package home.data

import kotlinx.serialization.Serializable

@Serializable
data class ImageItem(
    val author: String,
    val category: String,
    val path: String
)