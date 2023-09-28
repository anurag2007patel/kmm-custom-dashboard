package product.repository

import product.data.Profile

/**
 * Created by Anurag on 27/09/23 3:15 pm
 **/
interface ProductRepository {

    suspend fun getProfileData(): Profile
}