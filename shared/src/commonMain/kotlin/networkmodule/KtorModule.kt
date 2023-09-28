package networkmodule

import constant.NetworkConstants.BaseUrl.Companion.IMAGE_BASE_URL
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*

/**
 * Created by Anurag on 26/09/23 10:42 pm
 **/
object KtorModule {

    private val httpClient: HttpClient = HttpClient {
        defaultRequest {
            url(IMAGE_BASE_URL)
        }
        install(ContentNegotiation) {
            json()
            HttpResponseValidator {
                validateResponse { response ->
                   val error: Error = response.body()
                    print(error.message)
                }
            }
        }
        /*install(HttpRequestRetry){
            maxRetries = 3
            retryIf { httpRequest, httpResponse ->
                httpResponse.status.value != 200 or 201
            }
        }*/

    }

    val getHttpClient: HttpClient get() = httpClient


    fun closeHttpClient(){
        httpClient.close()
    }

}