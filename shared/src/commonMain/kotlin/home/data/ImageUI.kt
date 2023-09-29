package home.data



data class ImageUI(
    val birdList: List<ImageItem> = emptyList(),
    val category: String? = ""
) {

    val images: Set<String> = birdList.map {
        it.category
    }.toSet()

    val filterImages = birdList.filter {
        it.category == category
    }

    val imageList = if (filterImages.isNullOrEmpty()) {
        birdList
    }else {
        filterImages
    }
}