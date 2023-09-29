package product.data

import kotlinx.serialization.Serializable

@Serializable
data class Profile(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int,
)