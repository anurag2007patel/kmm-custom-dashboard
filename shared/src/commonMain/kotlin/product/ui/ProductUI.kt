package product.ui

import product.data.Profile

/**
 * Created by Anurag on 27/09/23 3:31 pm
 **/
data class ProductUI(

    val profile: Profile? = null,
    val category: String? = ""
){
    val categorySet  = profile?.products?.map {
        it.category
    }?.toSet()

    private val filterProducts = profile?.products?.filter {
        it.category == category
    }

    val productList = if (filterProducts.isNullOrEmpty()){
           profile?.products
    }else {
        filterProducts
    }
}
