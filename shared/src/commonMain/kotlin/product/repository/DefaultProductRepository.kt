package product.repository

import constant.NetworkConstants
import io.ktor.client.call.*
import io.ktor.client.request.*
import networkmodule.KtorModule
import product.data.Profile

/**
 * Created by Anurag on 27/09/23 3:15 pm
 **/
class DefaultProductRepository: ProductRepository {

    override suspend fun getProfileData(): Profile {
        val request = KtorModule.getHttpClient
            .get("products") {
            }
        println("Anurag Request Url = ${request.toString()}")
        return request.body<Profile>()
    }
}